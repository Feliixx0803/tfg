import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidadorFechasService {

  constructor() { }
  /**
   * Valida si una fecha es válida.
   * @param fecha La fecha a validar.
   * @returns `true` si la fecha es válida, de lo contrario `false`.
   */
  validarFecha(fecha: Date): boolean {
    let isCorrect :boolean;
    if(fecha == undefined){
      isCorrect = false;
    } else{
      isCorrect = true;
    }

    return isCorrect;
  }

  /**
   * Valida si un año es válido.
   * @param fecha La fecha que contiene el año a validar.
   * @returns `true` si el año es válido, de lo contrario `false`.
   */
  validarAnio(fecha :Date){
    let isCorrect :boolean = false;
    const MIN_YEAR = 2000; // Año mínimo aceptable
    const MAX_YEAR = 2100; // Año máximo aceptable
    const fech = new Date(fecha);

    if(fech.getFullYear() <= MIN_YEAR ||
      fech.getFullYear() >= MAX_YEAR){
      isCorrect = false;
    } else isCorrect=true;
    return isCorrect;
  }
}
