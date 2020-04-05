package com.myapplication.myapp.service.document;

import com.myapplication.myapp.domain.document.PersonDocument;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonDocumentService {

  PersonDocument save(PersonDocument personDocument);

  List<PersonDocument> importPersons(List<PersonDocument> personDocuments);

  Optional<PersonDocument> findOne(Long id);

  Iterable<PersonDocument> findAll();

  Optional<PersonDocument> findPersonByid(long id);

  Page<PersonDocument> findByFirstName(String name, Pageable pageable);

  void deleteById(long id);
}
