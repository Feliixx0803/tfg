import { Component } from '@angular/core';
import {EstadoModel} from "../../../models/estado/estado-model";
import {EstadoService} from "../../../services/estado/estado.service";

@Component({
  selector: 'estado',
  templateUrl: './estado.component.html',
  styleUrls: ['./estado.component.scss']
})
export class EstadoComponent {
  estados: EstadoModel[];

  constructor(private estadoServicio: EstadoService) {
  }

  /**
   * Se ejecuta al inicializar el componente.
   * Obtiene todos los estados.
   */
  ngOnInit(): void {
    this.getAllEstados()
  }

  /**
   * Obtiene todos los estados y los asigna a la variable "estados".
   */
  private getAllEstados() {
    this.estadoServicio.getAllEstados().subscribe(estado => {
      this.estados = estado;
    })

  }
}
