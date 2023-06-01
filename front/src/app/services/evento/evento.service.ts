import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EventoModel} from "../../models/evento/evento-model";

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  getAllEventos() :Observable<EventoModel[]>{
    return this.http.get<EventoModel[]>(this.apiUrl+'/evento/all');
  }

  createEvento(eventoNuevo : EventoModel){
    return this.http.post<string>(`${this.apiUrl}/evento/add`, eventoNuevo);
  }

  findEventoByNombre(nombre: string | null): Observable<EventoModel>{
    return this.http.get<EventoModel>(`${this.apiUrl}/evento/findNombre/` + nombre);
  }
}
