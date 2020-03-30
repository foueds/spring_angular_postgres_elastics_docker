package com.myapplication.myapp.service;

import com.myapplication.myapp.controller.PersonController;
import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.domain.document.PersonDocument;
import com.myapplication.myapp.dto.Person;
import com.myapplication.myapp.service.document.PersonDocumentService;
import com.myapplication.myapp.service.entity.PersonEntityService;
import com.myapplication.myapp.utils.PersonMapper;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.elasticsearch.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

  private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

  PersonDocumentService personDocumentService;
  PersonEntityService personEntityService;

  public PersonService(PersonDocumentService personDocumentService, PersonEntityService personEntityService) {
    this.personDocumentService = personDocumentService;
    this.personEntityService = personEntityService;
  }

  public Person saveAll(Person personDto) {
    PersonMapper personMapper = new PersonMapper();
    PersonEntity personEntity = personEntityService.save(personMapper.convertDtoToEntity(personDto));
    personDocumentService.save(personMapper.convertEntityToDocument(personEntity));

    return personDto;
  }

  public List<Person> getAllPersonList() {
    PersonMapper personMapper = new PersonMapper();
    List<Person> persons = new ArrayList<>();
    personDocumentService.findAll().forEach(personEs -> persons.add(personMapper.convertDocumentToDto(personEs)));
    return persons;
  }

  public Person findPersonById(Long personId) throws ResourceNotFoundException {
    PersonMapper personMapper = new PersonMapper();
    PersonDocument personDocument = personDocumentService.findPersonByid(personId)
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
    return personMapper.convertDocumentToDto(personDocument);
  }

  public Person findPersonByName(String name, Pageable pageable) throws ResourceNotFoundException {
    PersonMapper personMapper = new PersonMapper();
    pageable = pageable != null ? pageable : PageRequest.of(0, 10);
    PersonDocument person = personDocumentService.findByFirstName(name, pageable).stream().findFirst()
      .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + name));
    return personMapper.convertDocumentToDto(person);
  }

  public void deletePerson(Long id){
    if (!personDocumentService.findPersonByid(id).isPresent() || !personEntityService.findPersonByid(id).isPresent()) {
      throw new ResourceNotFoundException("Person not found");
    }
    personDocumentService.deleteById(id);
    personEntityService.deleteById(id);
  }

  public Person updatePerson(Person person) throws ResourceNotFoundException {
    PersonMapper personMapper = new PersonMapper();

    logger.debug("REST request to update Employee : {}", person);
    if (person.getId() == null) {
      throw new ResourceNotFoundException("Invalid id");
    }
    PersonEntity result = personEntityService.save(personMapper.convertDtoToEntity(person));
    PersonDocument personDocumentResult = personMapper.convertEntityToDocument(result);
    personDocumentService.save(personDocumentResult);
    return personMapper.convertDocumentToDto(personDocumentResult);
  }
}
