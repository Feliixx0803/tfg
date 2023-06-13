import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EventoModel} from "../../models/evento/evento-model";
import { CrearEventoDTO } from 'src/app/components/evento/crear-evento/crear-evento.component';

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  /**
   * La URL base de la API para las solicitudes HTTP.
   */
  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  /**
   * Obtiene todos los eventos.
   * @returns Un `Observable` que emite una matriz de objetos `EventoModel`.
   */
  getAllEventos() :Observable<EventoModel[]>{
    return this.http.get<EventoModel[]>(this.apiUrl+'/evento/all');
  }


  /**
   * Crea un nuevo evento.
   * @param eventoNuevo Los datos del nuevo evento a crear.
   * @returns Un `Observable` que emite una cadena con el ID del evento creado.
   */
  createEvento(eventoNuevo : CrearEventoDTO){
    return this.http.post<string>(`${this.apiUrl}/evento/add`, eventoNuevo);
  }


  /**
   * Busca un evento por su nombre.
   * @param nombre El nombre del evento a buscar.
   * @returns Un `Observable` que emite un objeto `EventoModel` que coincide con el nombre proporcionado.
   */
  findEventoByNombre(nombre: string | null): Observable<EventoModel>{
    return this.http.get<EventoModel>(`${this.apiUrl}/evento/findNombre/` + nombre);
  }

  /**
   * Obtiene el ID de un evento por su nombre.
   * @param nombre El nombre del evento.
   * @returns Un `Observable` que emite un número que representa el ID del evento.
   */
  getIdByNombre(nombre: string): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/evento/findIdByNombre/` + nombre);
  }
}
