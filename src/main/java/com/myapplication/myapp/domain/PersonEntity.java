package com.myapplication.myapp.domain;

import io.swagger.annotations.ApiModel;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "person")
@ApiModel(description = "All details about the Person. ")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false)
    private String mailAddress;

    @Column(nullable = false)
    private String phoneNumber;

  public PersonEntity() {
  }

  public PersonEntity(String firstName, String lastName, Date birthDate, String mailAddress, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAddress = mailAddress;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonEntity)) {
            return false;
        }
        PersonEntity personEntity = (PersonEntity) o;
        return id == personEntity.id &&
              phoneNumber == personEntity.phoneNumber &&
              Objects.equals(firstName, personEntity.firstName) &&
              Objects.equals(lastName, personEntity.lastName) &&
              Objects.equals(birthDate, personEntity.birthDate) &&
              Objects.equals(mailAddress, personEntity.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, mailAddress, phoneNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", birthDate=" + birthDate +
              ", mailAddress='" + mailAddress + '\'' +
              ", phoneNumber=" + phoneNumber +
              '}';
    }
}
