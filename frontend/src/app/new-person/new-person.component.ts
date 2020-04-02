import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";
import { Location } from '@angular/common';

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
    console.log(`la personne ${this.newPerson} est crée`);
  }

  goBack(): void {
    this.location.back();
  }
}
