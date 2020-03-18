package com.myapplication.myapp.repository.es;

import com.myapplication.myapp.domain.es.PersonEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEsRepository extends ElasticsearchRepository<PersonEs, Long> {

  Page<PersonEs> findByFirstName(String name, Pageable pageable);

}
