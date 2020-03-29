package com.myapplication.myapp.controller;

import com.myapplication.myapp.config.ElasticSearchConfig;
import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.domain.es.PersonEs;
import com.myapplication.myapp.dto.PersonDto;
import com.myapplication.myapp.service.PersonService;
import com.myapplication.myapp.service.es.PersonEsService;
import com.myapplication.myapp.service.mapper.PersonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.elasticsearch.ResourceAlreadyExistsException;
import org.elasticsearch.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
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

  private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

  private PersonService personService;
  private PersonEsService personEsService;
  private PersonMapper personMapper;

  public PersonController(PersonService personService, PersonEsService personEsService, PersonMapper personMapper) {
    this.personService = personService;
    this.personEsService = personEsService;
    this.personMapper = personMapper;
  }

  @ApiOperation(value = "View a list of available person", response = Person.class)
  @GetMapping("/person/{id}")
  public PersonDto findPersonById(@ApiParam(value = "Return person details by id", required = true) @PathVariable(value = "id") Long personId)
    throws ResourceNotFoundException {
    PersonEs personEs = personEsService.findById(personId)
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
    return personMapper.convertPersonEsToPersonDto(personEs);

  }

  @ApiOperation(value = "View a list of all persons", response = Person.class)
  @GetMapping("/person")
  public List<PersonDto> getListOfAllPerson() {
    List<PersonDto> persons = new ArrayList<>();
    personEsService.findAll().forEach(personEs -> persons.add(personMapper.convertPersonEsToPersonDto(personEs)));
    return persons;
  }

  @ApiOperation(value = "Return person details by name", response = Person.class)
  @GetMapping("/person/firstname/{firstName}")
  public PersonDto findByFirstName(@PathVariable(value = "firstName") String firstName, @RequestParam(required = false) Pageable pageable)
    throws ResourceNotFoundException {
    pageable = pageable != null ? pageable : PageRequest.of(0, 10);
    PersonEs person = personEsService.findByFirstName(firstName, pageable).stream().findFirst()
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + firstName));
    return personMapper.convertPersonEsToPersonDto(person);
  }

  @ApiOperation(value = "Create new person", response = Person.class)
  @PostMapping("/person")
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional
  public PersonDto createPerson(@RequestBody PersonDto person) throws ResourceAlreadyExistsException{
    Person personResult = personService.save(personMapper.convertToPersonEntity(person));
    PersonEs personEsResult = personMapper.convertPersonToPersonEs(personResult);
    personEsService.save(personEsResult);
    return personMapper.convertPersonEsToPersonDto(personEsResult);
  }

  @ApiOperation(value = "delete person by id", response = Person.class)
  @DeleteMapping("/person/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public void deletePerson(@PathVariable Long id) {
    logger.debug("REST request to delete Employee : {}", id);
    if (!personEsService.findById(id).isPresent()) {
      throw new ResourceNotFoundException("Person not found");
    }
    personEsService.deleteById(id);
    personService.deleteById(id);
  }

  @ApiOperation(value = "update person with new details", response = Person.class)
  @PutMapping("/person/")
  @Transactional
  public PersonDto updatePerson(@RequestBody PersonDto person) throws ResourceNotFoundException {
    logger.debug("REST request to update Employee : {}", person);
    if (person.getId() == null) {
      throw new ResourceNotFoundException("Invalid id");
    }
    Person result = personService.save(personMapper.convertToPersonEntity(person));
    PersonEs personEsResult = personMapper.convertPersonToPersonEs(result);
    personEsService.save(personEsResult);
    return personMapper.convertPersonEsToPersonDto(personEsResult);
  }

}
