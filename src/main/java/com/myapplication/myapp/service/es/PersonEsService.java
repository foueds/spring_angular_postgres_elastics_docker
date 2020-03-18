package com.myapplication.myapp.service.es;

import com.myapplication.myapp.domain.es.PersonEs;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonEsService {

  PersonEs save(PersonEs personEs);

  Optional<PersonEs> findOne(Long id);

  Iterable<PersonEs> findAll();

  Optional<PersonEs> findById(long id);

  Page<PersonEs> findByFirstName(String name, Pageable pageable);
}
