package com.myapplication.myapp.repository.document;

import com.myapplication.myapp.domain.document.PersonDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEsRepository extends ElasticsearchRepository<PersonDocument, Long> {

  Page<PersonDocument> findByFirstName(String name, Pageable pageable);

}
