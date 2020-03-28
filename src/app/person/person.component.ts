import { Component, OnInit } from '@angular/core';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personSelected: Person;
  personsList: Array<Person>;

  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
    this.getPersonById();
    this.getAllPersons();
  }

  private getPersonById() {
    this.personService.getPersonById(8).subscribe(
      result => this.personSelected = result
    )
  }

  getAllPersons(): void {
    this.personService.getPersonList().subscribe(
      personList => this.personsList = personList
    )
  }

}
