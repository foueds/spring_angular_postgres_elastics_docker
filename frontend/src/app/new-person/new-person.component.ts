import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {
  newPerson: Person;

  constructor(private personService: PersonService, private location: Location) {
  }

  ngOnInit() {
    this.newPerson = new Person('', '', new Date(), '', 0);
  }


  addPerson(): void {
    this.personService.addPerson(this.newPerson).subscribe();
    console.log(`New person added:  ${this.newPerson} `);
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }
}
