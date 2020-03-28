package com.myapplication.myapp.service.mapper;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.domain.es.PersonEs;
import com.myapplication.myapp.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

  @Autowired
  ModelMapper modelMapper;

  public PersonEs convertPersonToPersonEs(Person person) {
    PersonEs personEs = new PersonEs();

    personEs.setId(person.getId());
    personEs.setFirstName(person.getFirstName());
    personEs.setLastName(person.getLastName());
    personEs.setBirthDate(person.getBirthDate());
    personEs.setmailAddress(person.getmailAddress());
    personEs.setPhoneNumber(person.getPhoneNumber());
    return personEs;
  }

  public Person convertPersonEsToPerson(PersonEs personEs) {
    Person person = new Person();

    person.setId(personEs.getId());
    person.setFirstName(personEs.getFirstName());
    person.setLastName(personEs.getLastName());
    person.setBirthDate(personEs.getBirthDate());
    person.setmailAddress(personEs.getmailAddress());
    person.setPhoneNumber(personEs.getPhoneNumber());
    return person;
  }

  public Person convertToPersonEntity(PersonDto personDto) {
    return modelMapper.map(personDto, Person.class);
  }

  public PersonDto convertToPersonDto(Person person) {
    return modelMapper.map(person, PersonDto.class);
  }

  public PersonDto convertPersonEsToPersonDto(PersonEs personEs) {
    return convertToPersonDto(convertPersonEsToPerson(personEs));
  }

  public PersonEs convertPersonDtoToPersonEs(PersonDto personDto) {
    return convertPersonToPersonEs(convertToPersonEntity(personDto));
  }

}
