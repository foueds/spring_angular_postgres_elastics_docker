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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "person")
@ApiModel(description = "All details about the Person. ")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    @Column(nullable = false)
    private String mailAdress;

    @Column(nullable = false)
    private long phoneNumber;

  public Person(String firstName, String lastName, Date birthDate, String mailAdress, long phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAdress = mailAdress;
    this.phoneNumber = phoneNumber;
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

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id &&
              phoneNumber == person.phoneNumber &&
              Objects.equals(firstName, person.firstName) &&
              Objects.equals(lastName, person.lastName) &&
              Objects.equals(birthDate, person.birthDate) &&
              Objects.equals(mailAdress, person.mailAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, mailAdress, phoneNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", birthDate=" + birthDate +
              ", mailAdress='" + mailAdress + '\'' +
              ", phoneNumber=" + phoneNumber +
              '}';
    }
}
