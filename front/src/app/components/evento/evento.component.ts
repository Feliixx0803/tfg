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
  eventosFiltrados: EventoModel[] = [];

  constructor(private eventoServicio: EventoService) {
  }
  selectDay(day: Date) {
    this.eventosFiltrados = this.eventos.filter(evento =>
      this.compararFechas(evento.fechaInicio, evento.fechaFin, day)
    );
  }
  compararFechas(fechaInicio: Date, fechaFin: Date, selectedDate: Date): boolean {
    const start = new Date(fechaInicio);
    const end = new Date(fechaFin);
    const selected = new Date(selectedDate);
  
    return selected >= start && selected <= end;
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
