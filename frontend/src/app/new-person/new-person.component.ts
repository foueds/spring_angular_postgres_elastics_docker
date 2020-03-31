import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";
import { Location } from '@angular/common';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {

  addPersonForm: FormGroup;

  newPerson: Person;

  constructor(private personService: PersonService, private location: Location) {
  }

  ngOnInit() {
    this.addPersonForm = new FormGroup({
      id: new FormControl(),
      firstName: new FormControl(),
      lastName: new FormControl(),
      birthDate: new FormControl(),
      mailAddress: new FormControl(),
      phoneNumber: new FormControl(),
    });
  }


  addPerson(): void {
    let id = this.addPersonForm.get('id').value;
    let firstName = this.addPersonForm.get('firstName').value;
    let lastName = this.addPersonForm.get('lastName').value;
    let birthDate = this.addPersonForm.get('birthDate').value;
    let mailAddress = this.addPersonForm.get('mailAddress').value;
    let phoneNumber = this.addPersonForm.get('phoneNumber').value;
    this.newPerson = new Person(id, firstName, lastName, birthDate, mailAddress, phoneNumber);
    this.personService.addPerson(this.newPerson).subscribe();
  }

  goBack(): void {
    this.location.back();
  }
}
