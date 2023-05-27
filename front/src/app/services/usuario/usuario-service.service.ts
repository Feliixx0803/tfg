import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {UsuarioModel} from "../../models/usuario/usuario-model";

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http:HttpClient) { }

  getAllUsuarios() :Observable<UsuarioModel[]>{
    return this.http.get<UsuarioModel[]>(this.apiUrl+'/usuario/all');
  }

  createUser(nuevoUsuario: UsuarioModel): Observable<UsuarioModel> {
    return this.http.post<UsuarioModel>(`${this.apiUrl}/usuario/add`, nuevoUsuario);
  }

  updateUsuario(usuarioId: number, usuario: UsuarioModel): Observable<UsuarioModel> {
    return this.http.put<UsuarioModel>(`${this.apiUrl}/usuario/update/${usuarioId}`, usuario);
  }

  deleteUsuario(usuarioId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/usuario/delete/${usuarioId}`);
  }
}
