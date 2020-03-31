import { HttpHeaders } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";
import { catchError, tap } from "rxjs/operators";
import { Person } from "../entities/person";
import { InvokerService } from "./invoker.service";
import { LoggerService } from "./logger/logger.service";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  url_api: string = "api/person/"
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(public invokerService: InvokerService, private logger: LoggerService) {
  }

  private log(message: string) {
    this.logger.add(`Person Service: ${message}`);
  }

  public getPersonList(): Observable<any> {
    return this.invokerService.http.get(this.url_api);
  }

  public getPersonById(id: number): Observable<any> {
    return this.invokerService.http.get(this.url_api + id);
  }

  public deletePerson(id: number): Observable<Person> {
    const url = `${this.url_api}/${id}`;
    return this.invokerService.http.delete<Person>(url, this.httpOptions)
    .pipe(
      tap(_ => this.log(`deleted person with id =${id}`)),
      catchError(this.handleError<Person>('deletePerson'))
    );
  }

  public addPerson(person: Person): Observable<Person> {
    return this.invokerService.http.post<Person>(this.url_api, person, this.httpOptions)
    .pipe(
      tap((newPerson: Person) => this.log(`add person w/ id=${newPerson.id}`)),
      catchError(this.handleError<Person>('addPerson'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
