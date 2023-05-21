import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {RolModel} from "../../models/rol/rol-model";

@Injectable({
  providedIn: 'root'
})
export class RolService {
  apiUrl = environment.apiUrl;

  constructor(private http:HttpClient) { }

  getAllRoles() :Observable<RolModel[]>{
    return this.http.get<RolModel[]>(this.apiUrl+'/rol/all');
  }
}
