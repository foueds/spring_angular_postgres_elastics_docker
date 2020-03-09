package com.myapplication.myapp.controller;

import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Optional;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@Api(value = "Person Management System", description = "Operations pertaining to person in person Management System")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "View a list of available employees", response = Person.class)
    @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved person"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findPersonById(@ApiParam(value = "Person Id object store in database table", required = true)@PathVariable(value="id") Long personId)
          throws ResourceNotFoundException {
        Person person = personService.searchPersonByid(personId)
              .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        return ResponseEntity.ok().body(person);
    }

}
