import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {
  newPerson: Person;
  isNewPerson: boolean;

  constructor(private personService: PersonService, private location: Location, private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.isNewPerson = id == null;
    if (this.isNewPerson) {
      this.newPerson = new Person('', '', new Date(), '', 0);
    } else {
      this.personService.getPersonById(+id).subscribe(
        person => this.newPerson = person
      )
    }
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
