package com.myapplication.myapp.service.impl;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.repository.PersonRepository;
import com.myapplication.myapp.service.PersonService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @Override
    public Optional<Person> searchPersonByid(long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person createPerson(Person person){
      return personRepository.save(person);
    }
}
