package com.myapplication.myapp.service.document;

import com.myapplication.myapp.domain.document.PersonDocument;
import com.myapplication.myapp.repository.document.PersonEsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonDocumentServiceImpl implements PersonDocumentService {

  private PersonEsRepository personEsRepository;


  public PersonDocumentServiceImpl(PersonEsRepository personEsRepository) {
    this.personEsRepository = personEsRepository;
  }

  @Override
  public PersonDocument save(PersonDocument personDocument) {
    return personEsRepository.save(personDocument);
  }

  @Override
  public List<PersonDocument> importPersons(List<PersonDocument> personDocuments) {
    return (List<PersonDocument>) personEsRepository.saveAll(personDocuments);
  }

  @Override
  public Optional<PersonDocument> findOne(Long id) {
    return personEsRepository.findById(id);
  }

  @Override
  public Iterable<PersonDocument> findAll() {
    return personEsRepository.findAll();
  }

  @Override
  public Optional<PersonDocument> findPersonByid(long id) {
    return personEsRepository.findById(id);
  }

  @Override
  public Page<PersonDocument> findByFirstName(String name, Pageable pageable) {
    return personEsRepository.findByFirstName(name, pageable);
  }

  @Override
  public void deleteById(long id) {
    personEsRepository.deleteById(id);
  }
}
