package com.myapplication.myapp.service.es;

import com.myapplication.myapp.domain.es.PersonEs;
import com.myapplication.myapp.repository.es.PersonEsRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonEsServiceImpl implements PersonEsService {

  private PersonEsRepository personEsRepository;


  public PersonEsServiceImpl(PersonEsRepository personEsRepository){
    this.personEsRepository = personEsRepository;
  }

  @Override
  public PersonEs save(PersonEs personEs) {
    return personEsRepository.save(personEs);
  }

  @Override
  public Optional<PersonEs> findOne(Long id) {
    return personEsRepository.findById(id);
  }

  @Override
  public Iterable<PersonEs> findAll() {
    return personEsRepository.findAll();
  }

  @Override
  public Optional<PersonEs> findById(long id){
    return personEsRepository.findById(id);
  }

  @Override
  public Page<PersonEs> findByFirstName(String name, Pageable pageable) {
    return personEsRepository.findByFirstName(name, pageable);
  }
}
