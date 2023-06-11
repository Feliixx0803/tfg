import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {UsuarioModel} from "../../models/usuario/usuario-model";

export interface DatosUsuario{
  nombre: string;
  email: string;
  telefono: string;
  nombreRol: string;
}

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  getAllUsuarios() :Observable<UsuarioModel[]>{
    return this.http.get<UsuarioModel[]>(this.apiUrl+'/usuario/all');
  }

  /*createUser(nuevoUsuario: UsuarioModel): Observable<UsuarioModel> {
    return this.http.post<UsuarioModel>(`${this.apiUrl}/usuario/add`, nuevoUsuario);
  }*/

  updateUsuario(datosUsuarioUpdate: DatosUsuario, idUsuario: number): Observable<DatosUsuario>{
    return this.http.put<DatosUsuario>(`${this.apiUrl}/usuario/update/${idUsuario}`, datosUsuarioUpdate);
  }

  deleteUsuario(usuarioId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/usuario/delete/${usuarioId}`);
  }

  getIdByNombre(nombre: string | null): Observable<number>{
    return this.http.get<number>(`${this.apiUrl}/usuario/findIdByName/${nombre}`);
  }

  getUserByNombre(nombre: string | null): Observable<UsuarioModel> {
    return this.http.get<UsuarioModel>(`${this.apiUrl}/usuario/findByName/${nombre}`);
  }

  getDatosPaginaUsuario(nombre: string | null) {
    return this.http.get<DatosUsuario>(`${this.apiUrl}/usuario/findByName/${nombre}`);
  }
  
}
