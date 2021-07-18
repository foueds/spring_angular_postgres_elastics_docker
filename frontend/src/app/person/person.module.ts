import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PersonRoutingModule} from "./person-routing.module";
import {PersonComponent} from "./person.component";
import {MatButtonModule, MatIconModule, MatListModule, MatPaginatorModule, MatSidenavModule, MatTableModule, MatToolbarModule} from "@angular/material";

@NgModule({
  declarations: [PersonComponent],
  imports: [
    CommonModule,
    PersonRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule
  ]
})
export class PersonModule { }
