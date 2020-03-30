package com.myapplication.myapp.service.entity;

import com.myapplication.myapp.domain.PersonEntity;
import java.util.Optional;

public interface PersonEntityService {

  Optional<PersonEntity> findPersonByid(long id);

  PersonEntity save(PersonEntity personEntity);

  void deleteById(long id);
}
