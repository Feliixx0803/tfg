import { Component, OnInit } from '@angular/core';
import { CalendarView, CalendarEvent, CalendarMonthViewDay } from 'angular-calendar';
import { startOfDay, endOfDay, subDays, addDays, endOfMonth, isSameDay, isSameMonth, addHours, subMonths, addMonths, startOfMonth} from 'date-fns';

import { formatDate } from '@angular/common'; // Importa la función formatDate de @angular/common
import { Router } from '@angular/router';
import { EventoService } from 'src/app/services/evento/evento.service';
import { EventoModel } from 'src/app/models/evento/evento-model';
import * as moment from 'moment';


@Component({
  selector: 'calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.scss']
})
export class CalendarioComponent implements OnInit {
  selectedDate: Date = new Date(); // Fecha seleccionada por el usuario
  fechaSeleccionada = moment();
  mostrarDivEventos: boolean = false;
  eventos: EventoModel[] = [];
  eventosFiltrados: EventoModel[] = [];
  noEventos: boolean;

  constructor(public eventoService: EventoService){}

  ngOnInit() {
    // Carga eventos desde BD
    this.mostrarEventos(this.selectedDate);
  }


  /**
   * Maneja el cambio de fecha seleccionada por el usuario.
   */
  cambioFechaSeleccionada(){
    this.selectedDate = this.fechaSeleccionada.toDate();
    this.mostrarEventos(this.selectedDate);
  }

  /**
   * Obtiene y muestra los eventos para la fecha seleccionada.
   * @param selectedDate La fecha seleccionada.
   */
  mostrarEventos(selectedDate : Date): void{
    this.noEventos = false;

    //console.log(dia);

    //this.selectedDate = new Date();
    //this.selectedDate.setDate(dia);

    this.eventoService.getAllEventos().subscribe(eventos => {
      this.eventos = eventos;
      this.filtrarEventos(this.selectedDate);
      if(this.eventosFiltrados.length == 0) this.noEventos = true; else this.noEventos = false;
    });

    this.mostrarDivEventos = true;
  }

  /**
   * Filtra los eventos por fecha para mostrar solo los correspondientes a la fecha seleccionada.
   * @param selectedDate La fecha seleccionada.
   */
  filtrarEventos(selectedDate: Date) {
    this.eventosFiltrados = this.eventos.filter(evento =>
      this.compararFechas(evento.fechaInicio, evento.fechaFin, selectedDate),
    );
  }

  /**
   * Compara las fechas de inicio y fin de un evento con la fecha seleccionada.
   * @param fechaInicioString La fecha de inicio del evento como una cadena de texto.
   * @param fechaFinString La fecha de fin del evento como una cadena de texto.
   * @param selectedDate La fecha seleccionada.
   * @returns True si la fecha seleccionada está dentro del rango de fechas del evento, False de lo contrario.
   */
  compararFechas(fechaInicioString: Date, fechaFinString: Date, selectedDate: Date): boolean {
    //Estan en formato YY-MM-DD los pasamos a formato Date para compararlo con la fecha seleccionada
    const fechaInicio :Date = new Date(fechaInicioString) ;
    const fechaFin :Date = new Date(fechaFinString);

    //Ponemos a 0 las horas,minutos y segundos para que no de conflictos al comparar
    fechaInicio.setHours(0,0,0,0);
    fechaFin.setHours(0,0,0,0);
    selectedDate.setHours(0,0,0,0);

    return selectedDate >= fechaInicio && selectedDate <= fechaFin;
  }
}
