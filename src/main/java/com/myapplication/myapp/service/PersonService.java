package com.myapplication.myapp.service;

import com.myapplication.myapp.domain.Person;
import java.util.Optional;

public interface PersonService {

  Optional<Person> searchPersonByid(long id);

  Person createPerson(Person person);
}
