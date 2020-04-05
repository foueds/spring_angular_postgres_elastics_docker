import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";
import { UtilsService } from "../service/utils.service";

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {

  newPerson: Person;
  isNewPerson: boolean;

  constructor(private personService: PersonService, private location: Location, private route: ActivatedRoute, private utils: UtilsService) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.isNewPerson = id == null;
    if (this.isNewPerson) {
      this.newPerson = new Person('', '', null, '', 0);
    } else {
      this.personService.getPersonById(+id).subscribe(
        person => this.newPerson = person
      )
    }
  }

  addPerson(): void {
    this.personService.addPerson(this.newPerson).subscribe(
      person => {
        console.log(`New person added:  ${person} `);
        this.utils.goBack()
      }
    );
  }

}
