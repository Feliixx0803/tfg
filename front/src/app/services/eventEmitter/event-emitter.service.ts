import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {

  eventoLogin: EventEmitter<any> = new EventEmitter();

  eventoLogout: EventEmitter<any> = new EventEmitter();

  constructor() { }
}
