package com.casdeveloper.dataserver.service.impl;

import com.casdeveloper.core.entity.Course;
import com.casdeveloper.core.helper.MapperClass;
import com.casdeveloper.core.model.CourseDto;
import com.casdeveloper.core.repository.CourseRepository;
import com.casdeveloper.dataserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends GenericServiceImpl implements CourseService {

    public CourseServiceImpl(@Autowired CourseRepository courseRepository, @Autowired MapperClass mapperClass) {
        this.mapperClass = mapperClass;
        this.tClass = Course.class;
        this.tDtoClass = CourseDto.class;
        this.repository = courseRepository;
    }

    @Override
    public CourseDto getById(Long id) {
        return findById(id);
    }

    @Override
    public List<CourseDto> getAll() {
        return findAll();
    }

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        return save(courseDto);
    }
}
