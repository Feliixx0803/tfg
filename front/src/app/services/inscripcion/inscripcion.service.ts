import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {InscripcionModel} from "../../models/inscripcion/inscripcion-model";
import { InscripcionDTO } from 'src/app/components/evento/detalles-evento/detalles-evento.component';

@Injectable({
  providedIn: 'root'
})
export class InscripcionService {

  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  /**
   * Obtiene todas las inscripciones.
   * @returns Un `Observable` que emite una matriz de objetos `InscripcionModel`.
   */
  getAllInscripciones() :Observable<InscripcionModel[]>{
    return this.http.get<InscripcionModel[]>(this.apiUrl+'/inscripcion/all');
  }

  /**
   * Realiza la inscripción de un usuario en un evento.
   * @param inscripcion Los datos de la inscripción a realizar.
   * @returns Un `Observable` que emite un objeto `InscripcionModel` que representa la inscripción realizada.
   */
  inscribirUsuario(inscripcion: InscripcionModel): Observable<InscripcionModel> {
    return this.http.post<InscripcionModel>(this.apiUrl+'/inscripcion/add', inscripcion, {responseType:  'json'});
  }

  /**
   * Realiza la inscripción de un usuario en un evento utilizando un DTO (Objeto de Transferencia de Datos) específico.
   * @param inscripcionDTO Los datos de la inscripción en formato DTO.
   * @returns Un `Observable` que emite una cadena que representa el resultado de la inscripción.
   */
  inscribirUsuarioDTO(inscripcionDTO: InscripcionDTO): Observable<string> {
    return this.http.post<string>(this.apiUrl+'/inscripcion/adddto', inscripcionDTO);
  }

  /**
   * Comprueba si existen inscripciones repetidas para un evento y un usuario específicos.
   * @param idEvento El ID del evento.
   * @param idUsuario El ID del usuario.
   * @returns Un `Observable` que emite un valor booleano indicando si existen inscripciones repetidas (true) o no (false).
   */
  comprobarRepeticiones(idEvento: number, idUsuario: number): Observable<boolean> {
    return this.http.get<boolean>(this.apiUrl+'/inscripcion/comprobarRepeticiones/' + idEvento + "/" + idUsuario);
  }
}
