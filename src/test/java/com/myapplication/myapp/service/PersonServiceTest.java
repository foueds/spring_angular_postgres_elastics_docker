package com.myapplication.myapp.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.myapplication.myapp.builder.PersonBuilder;
import com.myapplication.myapp.domain.Person;
import com.myapplication.myapp.repository.PersonRepository;
import com.myapplication.myapp.service.impl.PersonServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonServiceImpl personService;

  @Test
  public void i_get_a_valid_person_when_searching_by_id() {

   //Given
    Person person = PersonBuilder.aPerson()
      .withId(1L)
      .withFirstName("foued")
      .withLastName("sliti")
      .withmailAddress("foued.sliti@gmail.com")
      .withPhoneNumber("0751501601")
      .build();

    //When
    Optional<Person> personOptional = Optional.of(person);
    when(personRepository.findById(1L)).thenReturn(personOptional);
    Optional<Person> person1 = personService.searchPersonByid(1L);

    //Then
    assertAll(() -> assertEquals(personOptional, person1),
              () -> assertDoesNotThrow(() -> person1));
  }


}
