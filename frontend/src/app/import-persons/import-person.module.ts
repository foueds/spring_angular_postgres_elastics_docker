import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ImportPersonsComponent} from "./import-persons.component";
import {ImportPersonRoutingModule} from "./import-person-routing.module";

@NgModule({
  declarations: [ImportPersonsComponent],
  imports: [
    CommonModule,
    ImportPersonRoutingModule
  ]
})
export class ImportPersonModule { }
