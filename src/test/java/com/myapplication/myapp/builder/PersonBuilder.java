package com.myapplication.myapp.builder;

import com.myapplication.myapp.domain.Person;
import java.util.Date;

public final class PersonBuilder {

  private long id;
  private String firstName;
  private String lastName;
  private Date birthDate;
  private String mailAddress;
  private String phoneNumber;

  private PersonBuilder() {
  }

  public static PersonBuilder aPerson() {
    return new PersonBuilder();
  }

  public PersonBuilder withId(long id) {
    this.id = id;
    return this;
  }

  public PersonBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonBuilder withBirthDate(Date birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public PersonBuilder withmailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
    return this;
  }

  public PersonBuilder withPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Person build() {
    return new Person(firstName, lastName, birthDate, mailAddress, phoneNumber);
  }
}
