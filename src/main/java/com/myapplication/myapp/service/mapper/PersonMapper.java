package com.myapplication.myapp.service.mapper;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.domain.es.PersonEs;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {


  public PersonEs PersonToPersonEs(Person person) {
    PersonEs personEs = new PersonEs();

    personEs.setId(person.getId());
    personEs.setFirstName(person.getFirstName());
    personEs.setLastName(person.getLastName());
    personEs.setBirthDate(person.getBirthDate());
    personEs.setMailAdress(person.getMailAdress());
    personEs.setPhoneNumber(person.getPhoneNumber());
    return personEs;
  }

  public Person PersonEsToPerson(PersonEs personEs) {
    Person person = new Person();

    person.setId(personEs.getId());
    person.setFirstName(personEs.getFirstName());
    person.setLastName(personEs.getLastName());
    person.setBirthDate(personEs.getBirthDate());
    person.setMailAdress(personEs.getMailAdress());
    person.setPhoneNumber(personEs.getPhoneNumber());
    return person;
  }
}
