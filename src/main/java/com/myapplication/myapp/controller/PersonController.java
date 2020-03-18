package com.myapplication.myapp.controller;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.domain.es.PersonEs;
import com.myapplication.myapp.service.PersonService;
import com.myapplication.myapp.service.es.PersonEsService;
import com.myapplication.myapp.service.mapper.PersonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.net.URI;
import java.net.URISyntaxException;
import javax.transaction.Transactional;
import org.elasticsearch.ResourceAlreadyExistsException;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Person Management System", description = "Operations pertaining to person in person Management System")
public class PersonController {

  private PersonService personService;
  private PersonEsService personEsService;
  private PersonMapper personMapper;

  public PersonController(PersonService personService, PersonEsService personEsService, PersonMapper personMapper) {
    this.personService = personService;
    this.personEsService = personEsService;
    this.personMapper = personMapper;
  }

  @ApiOperation(value = "View a list of available employees", response = Person.class)
  @GetMapping("/person/{id}")
  public Person findPersonById(
    @ApiParam(value = "Return person details by id", required = true) @PathVariable(value = "id") Long personId)
    throws ResourceNotFoundException {
    PersonEs personEs = personEsService.findById(personId)
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
      return personMapper.PersonEsToPerson(personEs);
  }

  @ApiOperation(value = "Return person details by name", response = Person.class)
  @GetMapping("/person/firstname/{firstName}")
  public Person findByFirstName(@PathVariable(value = "firstName") String firstName, @RequestParam(required = false) Pageable pageable)
    throws ResourceNotFoundException {
    pageable = pageable != null ? pageable : PageRequest.of(0, 10);
    PersonEs person = personEsService.findByFirstName(firstName, pageable).stream().findFirst()
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + firstName));
    return personMapper.PersonEsToPerson(person);
  }

  @PostMapping("/person")
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional
  public ResponseEntity<Person> createPerson(@RequestBody Person person) throws ResourceAlreadyExistsException, URISyntaxException {
    Person personResult = personService.createPerson(person);
    PersonEs personEsResult = personMapper.PersonToPersonEs(personResult);
    personEsService.save(personEsResult);
    return ResponseEntity.created(new URI("/api/person/" + personResult.getId()))
      .body(personResult);
  }
}
