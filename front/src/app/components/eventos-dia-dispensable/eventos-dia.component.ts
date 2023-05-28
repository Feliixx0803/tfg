import { Component, Input } from '@angular/core';
import { EventoComponent } from '../evento/evento.component';
@Component({
  selector: 'eventos-dia',
  templateUrl: './eventos-dia.component.html',
  styleUrls: ['./eventos-dia.component.scss']
})
export class EventosDiaComponent {

  @Input() day: Date ;
  @Input() eventosDelDia: any[] = [];

  eventosDelDiaFiltrados: any[] = [];
  // eventosDelDia: EventoComponent[] = [];
  ngOnChanges() {
    this.filtrarEventosPorFecha();
  }
  filtrarEventosPorFecha() {
    if (this.day) {
      this.eventosDelDiaFiltrados = this.eventosDelDia.filter(evento =>
        this.compararFechas(evento.fechaInicio, evento.fechaFin, this.day)
      );
    } else {
      this.eventosDelDiaFiltrados = [];
    }
  }
  compararFechas(fechaInicio: Date, fechaFin: Date, day: Date): boolean {
    const start = new Date(fechaInicio);
    const end = new Date(fechaFin);
    const currentDay = new Date(day);
    return start <= currentDay && currentDay <= end;
  }
  
}
