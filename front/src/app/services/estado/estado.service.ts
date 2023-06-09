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

  getAllEstados() :Observable<EstadoModel[]>{
    return this.http.get<EstadoModel[]>(this.apiUrl+'/estado/all');
  }
  verificarEstadoInscrito(nombreEstado: string): Observable<EstadoModel> {
    return this.http.post<EstadoModel>(`${this.apiUrl}/estado/findByName/${nombreEstado}`, {});
  }


  crearEstadoInscrito(): Observable<EstadoModel> {
    const nuevoEstado: EstadoModel = {
      nombre: 'Inscrito'
    };
    return this.http.post<EstadoModel>(this.apiUrl + '/estado/add', nuevoEstado);
  }
  
}
