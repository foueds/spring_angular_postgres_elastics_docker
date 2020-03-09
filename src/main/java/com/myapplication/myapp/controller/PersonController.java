package com.myapplication.myapp.controller;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.service.PersonService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findPerson/{id}")
    public Optional<Person> findPersonById(@PathVariable Long id) {
        return personService.searchPersonByid(id);
    }

}
