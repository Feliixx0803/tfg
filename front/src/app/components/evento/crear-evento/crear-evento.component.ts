import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {EventoService} from "../../../services/evento/evento.service";
import {EventoModel} from "../../../models/evento/evento-model";

@Component({
  selector: 'app-crear-evento',
  templateUrl: './crear-evento.component.html',
  styleUrls: ['./crear-evento.component.scss']
})
export class CrearEventoComponent {
  nombre :string;
  fechaInicio :Date;
  fechaFin :Date;
  descripcion :string;

  constructor(private router:Router, public eventoService: EventoService) {
  }

  registrarEvento() {
   /* const eventoNuevo: EventoModel = {
      nombre: this.nombre,
      fechaInicio: this.fechaInicio,
      fechaFin: this.fechaFin,
      descripcion: this.descripcion
    };

    this.eventoService.createEvento(eventoNuevo).subscribe((response)=>{
      console.log('Evento creado:', response);
      this.router.navigate(['/evento']);
    }, (error)=>{
      console.error('Error al crear evento:', error);
    });
*/
  }
}
