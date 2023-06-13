import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EstadoModel} from "../../models/estado/estado-model";

@Injectable({
  providedIn: 'root'
})
export class EstadoService {
  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }


  /**
   * Obtiene todos los estados.
   * @returns Un Observable que emite un array de objetos EstadoModel.
   */
  getAllEstados() :Observable<EstadoModel[]>{
    return this.http.get<EstadoModel[]>(this.apiUrl+'/estado/all');
  }

  /**
   * Verifica si existe un estado inscrito con el nombre especificado.
   * @param nombreEstado El nombre del estado a verificar.
   * @returns Un Observable que emite un objeto EstadoModel si se encuentra, de lo contrario, emite null.
   */
  verificarEstadoInscrito(nombreEstado: string): Observable<EstadoModel> {
    return this.http.post<EstadoModel>(`${this.apiUrl}/estado/findByName/${nombreEstado}`, {});
  }


  /**
   * Crea un nuevo estado inscrito.
   * @returns Un Observable que emite el objeto EstadoModel recién creado.
   */
  crearEstadoInscrito(): Observable<EstadoModel> {
    const nuevoEstado: EstadoModel = {
      nombre: 'Inscrito'
    };
    return this.http.post<EstadoModel>(this.apiUrl + '/estado/add', nuevoEstado);
  }

}
