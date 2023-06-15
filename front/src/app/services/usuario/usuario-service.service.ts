import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {UsuarioModel} from "../../models/usuario/usuario-model";
import { EventoModel } from 'src/app/models/evento/evento-model';
import { DatosEvento } from 'src/app/components/usuario/usuario.component';

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

  /**
   * Obtiene todos los usuarios.
   * @returns Un `Observable` que emite una matriz de objetos `UsuarioModel`.
   */
  getAllUsuarios() :Observable<UsuarioModel[]>{
    return this.http.get<UsuarioModel[]>(this.apiUrl+'/usuario/all');
  }

  /**
   * Actualiza los datos de un usuario.
   * @param datosUsuarioUpdate Los datos actualizados del usuario.
   * @param idUsuario El ID del usuario a actualizar.
   * @returns Un `Observable` que emite los datos actualizados del usuario.
   */
  updateUsuario(datosUsuarioUpdate: DatosUsuario, idUsuario: number): Observable<DatosUsuario>{
    return this.http.put<DatosUsuario>(`${this.apiUrl}/usuario/update/${idUsuario}`, datosUsuarioUpdate);
  }

  /**
   * Obtiene el ID de un usuario por su nombre.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite el ID del usuario.
   */
  getIdByNombre(nombre: string | null): Observable<number>{
    return this.http.get<number>(`${this.apiUrl}/usuario/findIdByName/${nombre}`);
  }

  /**
   * Obtiene los datos de un usuario por su nombre.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite los datos del usuario.
   */
  getUserByNombre(nombre: string | null): Observable<DatosUsuario> {
    return this.http.get<DatosUsuario>(`${this.apiUrl}/usuario/findByName/${nombre}`);
  }

  /**
   * Obtiene los datos de un usuario en forma de `UsuarioModel` por su nombre.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite un objeto `UsuarioModel` que contiene los datos del usuario.
   */
  //Devolver usuario con estructura UsuarioModel
  getUserByNombreModel(nombre: string | null): Observable<UsuarioModel> {
    return this.http.get<UsuarioModel>(`${this.apiUrl}/usuario/findByName/${nombre}`);
  }

  /**
   * Obtiene los datos de la página de usuario por su nombre.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite los datos de la página del usuario.
   */
  getDatosPaginaUsuario(nombre: string | null) {
    return this.http.get<DatosUsuario>(`${this.apiUrl}/usuario/findByName/${nombre}`);
  }

  /**
   * Obtiene los eventos inscritos por un usuario.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite una matriz de cadenas que representan los nombres de los eventos inscritos.
   */
  getEventosInscritos(nombre: string | null): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/usuario/getInscritos/${nombre}`);
  }

  /**
   * Obtiene los eventos gestionados por un usuario.
   * @param nombre El nombre del usuario.
   * @returns Un `Observable` que emite una matriz de cadenas que representan los nombres de los eventos gestionados.
   */
  getEventosGestionados(nombre: string | null): Observable<DatosEvento[]> {
    return this.http.get<DatosEvento[]>(`${this.apiUrl}/usuario/getGestionados/${nombre}`, {responseType: 'json'});
  }

  deleteInscripcion(idUsuario: number, idEvento: number) {
    return this.http.delete(`${this.apiUrl}/usuario/deleteInscripcion/${idUsuario}/${idEvento}`);
  }
}
