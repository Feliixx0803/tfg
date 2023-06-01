import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidadorFechasService {

  constructor() { }
  validarFecha(fecha: Date): boolean {
    let isCorrect :boolean;
    if(fecha == undefined){
      isCorrect = false;
    } else{
      isCorrect = true;
    }

    return isCorrect;
  }

  validarAnio(fecha :Date){
    let isCorrect :boolean = false;
    const MIN_YEAR = 1900; // Año mínimo aceptable
    const MAX_YEAR = 2100; // Año máximo aceptable
    const fech = new Date(fecha);

    if(fech.getFullYear() <= MIN_YEAR ||
      fech.getFullYear() >= MAX_YEAR){
      isCorrect = false;
    } else isCorrect=true;
    return isCorrect;
  }
}
