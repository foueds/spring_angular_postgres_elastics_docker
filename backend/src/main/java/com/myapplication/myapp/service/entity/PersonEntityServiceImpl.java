package com.myapplication.myapp.service.entity;

import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonEntityServiceImpl implements PersonEntityService {

  private PersonRepository personRepository;

  public PersonEntityServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  @Override
  public Optional<PersonEntity> findPersonByid(long id) {
    return personRepository.findById(id);
  }

  @Override
  public List<PersonEntity> findAll() {
    return personRepository.findAll();
  }


  @Override
  public PersonEntity save(PersonEntity personEntity) {
    return personRepository.save(personEntity);
  }

  @Override
  public List<PersonEntity> importPersons(List<PersonEntity> personEntities) {
    return personRepository.saveAll(personEntities);
  }

  @Override
  public void deleteById(long id) {
    personRepository.deleteById(id);
  }
}
