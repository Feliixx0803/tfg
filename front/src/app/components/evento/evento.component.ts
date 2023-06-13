import {Component, OnInit} from '@angular/core';
import {InscripcionService} from "../../services/inscripcion/inscripcion.service";
import {EventoModel} from "../../models/evento/evento-model";
import {EventoService} from "../../services/evento/evento.service";
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.scss']
})
export class EventoComponent implements OnInit{
  eventos: EventoModel[] = [];
  eventosFiltrados: EventoModel[] = [];
  isUsuarioLogeado :boolean = localStorage.getItem("usuario") !== null;

  constructor(private eventoServicio: EventoService) {
  }
  /**
   * Filtra los eventos por día.
   * @param day El día seleccionado.
   */
  selectDay(day: Date) {
    this.eventosFiltrados = this.eventos.filter(evento =>
      this.compararFechas(evento.fechaInicio, evento.fechaFin, day)
    );
  }
  /**
   * Compara las fechas de inicio y fin del evento con la fecha seleccionada.
   * @param fechaInicio Fecha de inicio del evento.
   * @param fechaFin Fecha de fin del evento.
   * @param selectedDate Fecha seleccionada.
   * @returns True si la fecha seleccionada está dentro del rango de fechas del evento, False en caso contrario.
   */
  compararFechas(fechaInicio: Date, fechaFin: Date, selectedDate: Date): boolean {
    const start = new Date(fechaInicio);
    const end = new Date(fechaFin);
    const selected = new Date(selectedDate);

    return selected >= start && selected <= end;
  }


  /**
   * Método que se ejecuta al inicializar el componente.
   */
  ngOnInit(): void {
    this.getAllEventos().then(() => {
      console.log(this.eventos);
      console.log("-------------");
      console.log(this.eventosFiltrados);
    });
  }

  /**
   * Obtiene todos los eventos.
   */
  private async getAllEventos() {
    this.eventos = await lastValueFrom(this.eventoServicio.getAllEventos().pipe());
  }
}
