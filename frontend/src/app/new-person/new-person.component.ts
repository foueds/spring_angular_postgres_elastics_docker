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
      firstName: new FormControl(),
      lastName: new FormControl(),
      birthDate: new FormControl(),
      mailAddress: new FormControl(),
      phoneNumber: new FormControl(),
    });
  }


  addPerson(): void {
    console.log(`la personne ${this.newPerson} est crée`);
  }

  goBack(): void {
    this.location.back();
  }
}
