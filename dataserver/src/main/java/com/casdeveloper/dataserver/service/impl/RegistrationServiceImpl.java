package com.casdeveloper.dataserver.service.impl;

import com.casdeveloper.core.entity.Registration;
import com.casdeveloper.core.entity.RegistrationId;
import com.casdeveloper.core.helper.MapperClass;
import com.casdeveloper.core.model.CourseDto;
import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;
import com.casdeveloper.core.repository.CourseRepository;
import com.casdeveloper.core.repository.PersonRepository;
import com.casdeveloper.core.repository.RegistrationRepository;
import com.casdeveloper.dataserver.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;
    private PersonRepository personRepository;
    private CourseRepository courseRepository;

    private MapperClass mapperClass;

    public RegistrationServiceImpl(@Autowired RegistrationRepository registrationRepository, @Autowired MapperClass mapperClass, @Autowired PersonRepository personRepository, @Autowired CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.mapperClass = mapperClass;
        this.personRepository = personRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public RegistrationDto getById(RegistrationIdDto registrationId) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        RegistrationId id = new RegistrationId();
        id.setCourse(courseRepository.getById(registrationId.getCourseDto().getId()));
        id.setPerson(personRepository.getById(registrationId.getPersonDto().getId()));
        Registration registration = registrationRepository.getById(id);
        RegistrationDto registrationDto = new RegistrationDto(new RegistrationIdDto(mapperClass.converToObjectClass(registration.getId().getCourse(), CourseDto.class), mapperClass.converToObjectClass(registration.getId().getPerson(), PersonDto.class)));
        return registrationDto;
    }

    @Override
    public List<RegistrationDto> getAll() {
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> registrationDtoList = registrations.stream().map(element -> {
            try {
                CourseDto courseDto = mapperClass.converToObjectClass(element.getId().getCourse(), CourseDto.class);
                PersonDto personDto = mapperClass.converToObjectClass(element.getId().getPerson(), PersonDto.class);
                return new RegistrationDto(new RegistrationIdDto(courseDto, personDto));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();

        return registrationDtoList;
    }

    @Override
    public RegistrationDto save(RegistrationDto registrationDto) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Registration registration = registrationRepository.save(mapperClass.converToObjectClass(registrationDto, Registration.class));
        registrationDto.getRegistrationIdDto().setCourseDto(mapperClass.converToObjectClass(courseRepository.getById(registration.getId().getCourse().getId()), CourseDto.class));
        registrationDto.getRegistrationIdDto().setPersonDto(mapperClass.converToObjectClass(personRepository.getById(registration.getId().getPerson().getId()), PersonDto.class));
        return registrationDto;
    }
}
