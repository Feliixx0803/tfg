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

  getAllInscripciones() :Observable<InscripcionModel[]>{
    return this.http.get<InscripcionModel[]>(this.apiUrl+'/inscripcion/all');
  }

  inscribirUsuario(inscripcion: InscripcionModel): Observable<InscripcionModel> {
    return this.http.post<InscripcionModel>(this.apiUrl+'/inscripcion/add', inscripcion, {responseType:  'json'});
  }
  
  inscribirUsuarioDTO(inscripcionDTO: InscripcionDTO): Observable<string> {
    return this.http.post<string>(this.apiUrl+'/inscripcion/adddto', inscripcionDTO);
  }

  comprobarRepeticiones(idEvento: number, idUsuario: number): Observable<boolean> {
    return this.http.get<boolean>(this.apiUrl+'/inscripcion/comprobarRepeticiones/' + idEvento + "/" + idUsuario);
  }
}
