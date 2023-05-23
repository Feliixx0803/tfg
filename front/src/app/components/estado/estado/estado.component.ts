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

  ngOnInit(): void {
    this.getAllEstados()
  }


  private getAllEstados() {
    this.estadoServicio.getAllEstados().subscribe(estado => {
      this.estados = estado;
    })

  }
}
