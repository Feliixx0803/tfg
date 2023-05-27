import { Component } from '@angular/core';
import {InscripcionService} from "../../services/inscripcion/inscripcion.service";
import {EventoModel} from "../../models/evento/evento-model";
import {EventoService} from "../../services/evento/evento.service";

@Component({
  selector: 'evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.scss']
})
export class EventoComponent {
  eventos: EventoModel[];

  constructor(private eventoServicio: EventoService) {
  }

  ngOnInit(): void {
    this.getAllEventos()
  }


  private getAllEventos() {
    this.eventoServicio.getAllEventos().subscribe(evento => {
      this.eventos = evento;
    })  

  }
}
