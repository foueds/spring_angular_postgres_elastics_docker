package com.myapplication.myapp.domain.document;

import java.util.Date;
import javax.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users", type = "person")
public class PersonDocument {

  @Id
  private long id;

  private String firstName;

  private String lastName;

  private Date birthDate;

  private String mailAddress;

  private String phoneNumber;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  @Override
  public String toString() {
    return "PersonEs{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", birthDate=" + birthDate +
      ", mailAddress='" + mailAddress + '\'' +
      ", phoneNumber=" + phoneNumber +
      '}';
  }
}
