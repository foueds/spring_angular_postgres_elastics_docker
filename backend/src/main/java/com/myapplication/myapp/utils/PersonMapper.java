package com.myapplication.myapp.utils;

import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.domain.document.PersonDocument;
import com.myapplication.myapp.dto.Person;
import java.util.ArrayList;
import java.util.List;


public class PersonMapper extends AbstractObjectMapper {


  public PersonDocument convertEntityToDocument(PersonEntity personEntity) {
    return convertTo(personEntity, PersonDocument.class);
  }

  public PersonEntity convertDocumentToEntity(PersonDocument personDocument) {
    return convertTo(personDocument, PersonEntity.class);
  }

  public PersonEntity convertDtoToEntity(Person person) {
    return convertTo(person, PersonEntity.class);
  }

  public Person convertEntityToDto(PersonEntity personEntity) {
    return convertTo(personEntity, Person.class);
  }

  public Person convertDocumentToDto(PersonDocument personDocument) {
    return convertTo(personDocument, Person.class);
  }

  public PersonDocument convertDtoToDocument(Person person) {
    return convertTo(person, PersonDocument.class);
  }

  public List<PersonEntity> convertDtoListToEntities(List<Person> personList) {
    List<PersonEntity> personEntities = new ArrayList<>();
    personList.forEach(person -> personEntities.add(convertTo(person, PersonEntity.class)));
    return personEntities;
  }

  public List<PersonDocument> convertEntitiesToDocuments(List<PersonEntity> personList) {
    List<PersonDocument> personEntities = new ArrayList<>();
    personList.forEach(person -> personEntities.add(convertTo(person, PersonDocument.class)));
    return personEntities;
  }
}
