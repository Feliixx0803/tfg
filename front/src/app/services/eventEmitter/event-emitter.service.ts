import { Injectable, EventEmitter } from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";

@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {

  eventoLogin: EventEmitter<any> = new EventEmitter();

  eventoLogout: EventEmitter<any> = new EventEmitter();

  eventoUsuarioActualizado: EventEmitter<UsuarioModel> = new EventEmitter<UsuarioModel>();
  constructor() { }
}
