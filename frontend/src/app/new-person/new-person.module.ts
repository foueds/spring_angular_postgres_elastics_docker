import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NewPersonComponent} from "./new-person.component";
import {NewPersonRoutingModule} from "./new-person-routing.module";
import {MatButtonModule, MatIconModule, MatListModule, MatPaginatorModule, MatSidenavModule, MatTableModule, MatToolbarModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [NewPersonComponent],
  imports: [
    CommonModule,
    FormsModule,
    NewPersonRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule
  ]
})
export class NewPersonModule { }
