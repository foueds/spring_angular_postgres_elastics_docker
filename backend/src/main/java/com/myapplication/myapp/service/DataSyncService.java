package com.myapplication.myapp.service;

import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.domain.document.PersonDocument;
import com.myapplication.myapp.service.document.PersonDocumentService;
import com.myapplication.myapp.service.entity.PersonEntityService;
import com.myapplication.myapp.utils.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataSyncService {

  @PostConstruct
  public void init() {
    syncData();
  }

  PersonDocumentService personDocumentService;
  PersonEntityService personEntityService;

  public DataSyncService(PersonDocumentService personDocumentService, PersonEntityService personEntityService) {
    this.personDocumentService = personDocumentService;
    this.personEntityService = personEntityService;
  }

  // Method to fetch data from PostgreSQL and push it to Elasticsearch
  public void syncData() {
    List<PersonEntity> entities = personEntityService.findAll();
    PersonMapper personMapper = new PersonMapper();
    List<PersonDocument> documents = entities.stream()
      .map(personMapper::convertEntityToDocument).collect(Collectors.toList());
    personDocumentService.saveAll(documents);
  }
}


