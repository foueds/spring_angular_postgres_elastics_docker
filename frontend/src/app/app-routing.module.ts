import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ImportPersonsComponent } from "./import-persons/import-persons.component";
import { NewPersonComponent } from "./new-person/new-person.component";
import { PersonComponent } from "./person/person.component";

const routes = [
  {path: '', redirectTo: '/persons', pathMatch: 'full'},
  {path: 'persons', component: PersonComponent},
  {path: 'newPerson', component: NewPersonComponent},
  {path: 'editPerson/:id', component: NewPersonComponent},
  {path: 'importPersons', component: ImportPersonsComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
