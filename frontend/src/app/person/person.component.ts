import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from "@angular/material";
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
  columnsToDisplay = ['firstName', 'lastName', 'birthDate', 'mailAddress', 'phoneNumber', 'actions'];

  @ViewChild(MatTable) table: MatTable<any>;

  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
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

  editPerson(personId: number): void {
    //todo
  }

  deletePerson(personId: number): void {
    this.personService.deletePerson(personId).subscribe(
      result => {
        this.personsList = this.personsList.filter((person: Person) => person.id != personId);
        this.table.renderRows();
      }
    );
  }

}
