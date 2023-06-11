import { Injectable, EventEmitter } from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import { DatosUsuario } from '../usuario/usuario-service.service';

@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {

  eventoLogin: EventEmitter<any> = new EventEmitter();

  eventoLogout: EventEmitter<any> = new EventEmitter();

  eventoUsuarioActualizado: EventEmitter<DatosUsuario> = new EventEmitter<DatosUsuario>();
  constructor() { }
}
