import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

const routes = [
  {path: '', loadChildren: () => import('./person/person.module').then(m => m.PersonModule)},
  {path: 'persons', loadChildren: () => import('./person/person.module').then(m => m.PersonModule)},
  {path: 'newPerson', loadChildren: () => import('./new-person/new-person.module').then(m => m.NewPersonModule)},
  {path: 'editPerson/:id', loadChildren: () => import('./new-person/new-person.module').then(m => m.NewPersonModule)},
  {path: 'editPerson/:id', loadChildren: () => import('./new-person/new-person.module').then(m => m.NewPersonModule)},
  {path: 'importPersons', loadChildren: () => import('./import-persons/import-person.module').then(m => m.ImportPersonModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
