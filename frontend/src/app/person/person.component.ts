import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from "@angular/material";
import { Router } from '@angular/router';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personsList: Array<Person>;
  columnsToDisplay = ['firstName', 'lastName', 'birthDate', 'mailAddress', 'phoneNumber', 'actions'];

  @ViewChild(MatTable, { static: false }) table: MatTable<any>;

  constructor(private personService: PersonService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllPersons();
  }

  getAllPersons(): void {
    this.personService.getPersonList().subscribe(
      personList => this.personsList = personList
    )
  }

  editPerson(personId: number): void {
    this.router.navigate([`editPerson/${personId}`]).then(
      () => {
        this.getAllPersons();
        this.table.renderRows()
      }
    );
  }

  deletePerson(personId: number): void {
    this.personService.deletePerson(personId).subscribe(
      () => {
        this.personsList = this.personsList.filter((person: Person) => person.id != personId);
        this.table.renderRows();
      }
    );
  }

}
