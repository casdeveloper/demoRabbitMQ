package com.casdeveloper.core.helper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperClass {

    ModelMapper modelMapper;

    public MapperClass() {
        this.modelMapper = new ModelMapper();
    }

    public <T> T converToObjectClass(Object o, Class tClass) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object objectClass = tClass.getConstructor().newInstance();
        modelMapper.map(o, objectClass);
        return (T) objectClass;

    }
    public List<?> convertToListObjectClass(List<Object> list, Class tClass){
        return  list.stream().map(element -> modelMapper.map(element,tClass)).collect(Collectors.toList());
    }

}
