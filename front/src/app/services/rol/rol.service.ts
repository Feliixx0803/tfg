import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {RolModel} from "../../models/rol/rol-model";

@Injectable({
  providedIn: 'root'
})
export class RolService {
  apiUrl = environment.apiUrl;

  constructor(private http:HttpClient) { }

  /**
   * Obtiene todos los roles disponibles.
   * @returns Un `Observable` que emite una matriz de objetos `RolModel`.
   */
  getAllRoles() :Observable<RolModel[]>{
    return this.http.get<RolModel[]>(this.apiUrl+'/rol/all');
  }

  /**
   * Crea un nuevo rol.
   * @param nombre Nombre del rol a añadir
   * @returns Un `Observable` que emite un objeto `RolModel`.
   */
  addRol() :Observable<RolModel> {
    return this.http.post<RolModel>(this.apiUrl+'/rol/add', {nombre: 'user'});
  }
}
