package com.myapplication.myapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Person {

  private Long id;

  private String firstName;

  private String lastName;

  @JsonFormat(pattern="yyyy-MM-dd")
  private Date birthDate;

  private String mailAddress;

  private String phoneNumber;

  public Person() {
  }

  public Person(long id, String firstName, String lastName, Date birthDate, String mailAddress, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAddress = mailAddress;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getMailAddress() {
    return mailAddress;
  }

  public void setMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
