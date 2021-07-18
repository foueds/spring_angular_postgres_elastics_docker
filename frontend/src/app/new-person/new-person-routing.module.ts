import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NewPersonComponent} from "./new-person.component";

const routes: Routes = [
  {path: '', component: NewPersonComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewPersonRoutingModule { }
