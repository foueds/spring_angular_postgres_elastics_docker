package com.myapplication.myapp.service;

import com.myapplication.myapp.domain.Person;
import java.util.Optional;
import org.hibernate.PersistentObjectException;

public interface PersonService {

  Optional<Person> searchPersonByid(long id);

  Person save(Person person);

  void deleteById(long id);
}
