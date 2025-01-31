package com.casdeveloper.dataserver.service.impl;

import com.casdeveloper.core.helper.MapperClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericServiceImpl {

    protected Class tClass;
    protected Class tDtoClass;
    protected MapperClass mapperClass;
    protected JpaRepository repository;


    public <T> T castObject(Object o) {
        try {
            return mapperClass.converToObjectClass(o, tClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T castDtoObject(Object o) {
        try {
            return mapperClass.converToObjectClass(o, tDtoClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<?> castListDtoObject(List<Object> list) {
        return mapperClass.convertToListObjectClass(list, tDtoClass);
    }

    public <T> T save(Object o) {
        return (T) castDtoObject(repository.save(castObject(o)));
    }

    public <T> T findById(Long id) {
        return (T) castDtoObject(repository.findById(id));
    }
    public <T> List<T> findAll() {
        return (List<T>) castListDtoObject(repository.findAll());
    }
}
