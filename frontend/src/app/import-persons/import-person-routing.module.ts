import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ImportPersonsComponent} from "./import-persons.component";

const routes: Routes = [
  {path: '', component: ImportPersonsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImportPersonRoutingModule { }
