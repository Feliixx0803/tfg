import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-ventana-error',
  templateUrl: './ventana-error.component.html',
  styleUrls: ['./ventana-error.component.scss']
})
export class VentanaErrorComponent {
  texto: string="";

  /**
   * Crea una instancia del componente VentanaErrorComponent.
   * @param data - Datos inyectados desde el componente padre.
   */
  constructor(@Inject (MAT_DIALOG_DATA) public data: any){
    this.texto = data.texto;
  }
}
