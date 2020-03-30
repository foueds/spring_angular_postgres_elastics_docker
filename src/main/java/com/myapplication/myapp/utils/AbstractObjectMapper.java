package com.myapplication.myapp.utils;

import org.modelmapper.ModelMapper;

public abstract class AbstractObjectMapper {


  public <D> D convertTo(Object source, Class<D> destinationType) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(source, destinationType);
  }

}
