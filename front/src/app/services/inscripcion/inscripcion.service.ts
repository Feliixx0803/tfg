import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {InscripcionModel} from "../../models/inscripcion/inscripcion-model";

@Injectable({
  providedIn: 'root'
})
export class InscripcionService {
  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  getAllInscripciones() :Observable<InscripcionModel[]>{
    return this.http.get<InscripcionModel[]>(this.apiUrl+'/inscripcion/all');
  }
  inscribirUsuario(inscripcion: InscripcionModel): Observable<any> {
    return this.http.post<InscripcionModel>(this.apiUrl+'/inscripcion/add', inscripcion);
  }
  
}
