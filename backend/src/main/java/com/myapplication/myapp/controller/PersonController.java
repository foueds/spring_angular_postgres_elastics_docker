package com.myapplication.myapp.controller;

import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.dto.Person;
import com.myapplication.myapp.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.elasticsearch.ResourceAlreadyExistsException;
import org.elasticsearch.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Person Management System", description = "Operations pertaining to person in person Management System")
public class PersonController {

  private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @ApiOperation(value = "View a list of available person", response = PersonEntity.class)
  @GetMapping("/person/{id}")
  public Person findPersonById(@ApiParam(value = "Return person details by id", required = true) @PathVariable(value = "id") Long personId) {
    return personService.findPersonById(personId);
  }

  @ApiOperation(value = "View a list of all persons", response = PersonEntity.class)
  @GetMapping("/person")
  public List<Person> getAllPersonList() {
    return personService.getAllPersonList();
  }

  @ApiOperation(value = "Return person details by name", response = PersonEntity.class)
  @GetMapping("/person/firstname/{firstName}")
  public Person findByFirstName(@PathVariable(value = "firstName") String firstName, @RequestParam(required = false) Pageable pageable) {
    return personService.findPersonByName(firstName, pageable);
  }

  @ApiOperation(value = "Create new person", response = PersonEntity.class)
  @PostMapping("/person")
  @ResponseStatus(HttpStatus.CREATED)
  public Person createPerson(@RequestBody Person person) throws ResourceAlreadyExistsException {
    return personService.saveAll(person);
  }

  @ApiOperation(value = "delete person by id", response = PersonEntity.class)
  @DeleteMapping("/person/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
  }

  @ApiOperation(value = "update person with new details", response = PersonEntity.class)
  @PutMapping("/person/")
  public Person updatePerson(@RequestBody Person person) throws ResourceNotFoundException {
    return personService.updatePerson(person);
  }

}
