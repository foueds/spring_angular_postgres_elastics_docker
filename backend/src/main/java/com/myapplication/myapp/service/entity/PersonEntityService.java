package com.myapplication.myapp.service.entity;

import com.myapplication.myapp.domain.PersonEntity;
import java.util.List;
import java.util.Optional;

public interface PersonEntityService {

  Optional<PersonEntity> findPersonByid(long id);

  PersonEntity save(PersonEntity personEntity);

  List<PersonEntity> importPersons(List<PersonEntity> personEntities);

  void deleteById(long id);

  List<PersonEntity> findAll();

}
