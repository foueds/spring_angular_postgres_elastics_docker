package com.myapplication.myapp.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.myapplication.myapp.builder.PersonBuilder;
import com.myapplication.myapp.domain.PersonEntity;
import com.myapplication.myapp.repository.PersonRepository;
import com.myapplication.myapp.service.entity.PersonEntityServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonEntityServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonEntityServiceImpl personService;

  @Test
  public void i_get_a_valid_person_when_searching_by_id() {

   //Given
    PersonEntity personEntity = PersonBuilder.aPerson()
      .withId(1L)
      .withFirstName("foued")
      .withLastName("sliti")
      .withmailAddress("foued.sliti@gmail.com")
      .withPhoneNumber("0751501601")
      .build();

    //When
    Optional<PersonEntity> personOptional = Optional.of(personEntity);
    when(personRepository.findById(1L)).thenReturn(personOptional);
    Optional<PersonEntity> person1 = personService.findPersonByid(1L);

    //Then
    assertAll(() -> assertEquals(personOptional, person1),
              () -> assertDoesNotThrow(() -> person1));
  }


}
