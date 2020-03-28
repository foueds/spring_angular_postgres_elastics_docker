import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { InvokerService } from "./invoker.service";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

 url_api : string= "api/person/"
  constructor(public invokerService: InvokerService) { }


  public getPersonList():  Observable<any> {
     return this.invokerService.http.get(this.url_api);
  }

  public getPersonById(id : number):  Observable<any> {
    return this.invokerService.http.get(this.url_api + id);
  }
}
