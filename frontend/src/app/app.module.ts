import {LayoutModule} from '@angular/cdk/layout';
import {DatePipe} from '@angular/common';
import {HttpClientModule} from "@angular/common/http";
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatButtonModule, MatIconModule, MatListModule, MatPaginatorModule, MatSidenavModule, MatTableModule, MatToolbarModule} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from "ngx-toastr";
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    ToastrModule.forRoot(),
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule {
}
