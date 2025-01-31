package com.casdeveloper.dataserver.service.impl;

import com.casdeveloper.core.entity.Person;
import com.casdeveloper.core.helper.MapperClass;
import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.core.repository.PersonRepository;
import com.casdeveloper.dataserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl extends GenericServiceImpl implements PersonService{


    public PersonServiceImpl(@Autowired MapperClass mapperClass, @Autowired PersonRepository personRepository) {
        this.mapperClass = mapperClass;
        this.tClass = Person.class;
        this.tDtoClass = PersonDto.class;
        this.repository = personRepository;
    }

    @Override
    public PersonDto getPerson(Long id) {
        return findById(id);
    }

    @Override
    public List<PersonDto> getPersons() {
        return findAll();
    }

    @Override
    public PersonDto savePerson(PersonDto personDto){
        return save(personDto);
    }
}
