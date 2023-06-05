import { Component, OnInit } from '@angular/core';
import { CalendarView, CalendarEvent, CalendarMonthViewDay } from 'angular-calendar';
import { startOfDay, endOfDay, subDays, addDays, endOfMonth, isSameDay, isSameMonth, addHours, subMonths, addMonths, startOfMonth} from 'date-fns';

import { formatDate } from '@angular/common'; // Importa la función formatDate de @angular/common
import { EventosDiaComponent } from '../eventos-dia-dispensable/eventos-dia.component';
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
  view: CalendarView = CalendarView.Month;
  viewDate: Date = new Date(); // La fecha actual del calendario
  selectedDate: Date = new Date(); // Fecha seleccionada por el usuario
  selectedDay: Date | null = null;
  currentDate: Date = new Date(); // Variable para almacenar la fecha actual
  currentMonth: number;

  fechaSeleccionada = moment();

  mostrarDivEventos: boolean = false;
  eventos: EventoModel[] = [];
  eventosFiltrados: EventoModel[] = [];

  noEventos: boolean;

  constructor(public eventoService: EventoService){}

  ngOnInit() {
    // Carga eventos desde BD
    this.mostrarEventos(this.selectedDate.getDate());
  }

  cambioFechaSeleccionada(){
    this.selectedDate = this.fechaSeleccionada.toDate();
    this.mostrarEventos(this.selectedDate.getDate());
  }

  mostrarEventos(dia: number): void{
    this.noEventos = false;

    console.log(dia);

    this.selectedDate = new Date();
    this.selectedDate.setDate(dia);

    this.eventoService.getAllEventos().subscribe(eventos => {
      this.eventos = eventos;
      this.filtrarEventos(this.selectedDate);

      console.log(this.eventosFiltrados);
      if(this.eventosFiltrados.length == 0) this.noEventos = true; else this.noEventos = false;
    });

    this.mostrarDivEventos = true;
  }

  filtrarEventos(day: Date) {
    this.eventosFiltrados = this.eventos.filter(evento =>
      this.compararFechas(evento.fechaInicio, evento.fechaFin, day)
    );
  }

  compararFechas(fechaInicio: Date, fechaFin: Date, selectedDate: Date): boolean {
    const start = new Date(fechaInicio).getDate();
    const end = new Date(fechaFin).getDate();
    const selected = new Date(selectedDate).getDate();

    return selected >= start && selected <= end;
  }

  chunkArray(array: any[], size: number): any[][] {
    const chunks = [];
    for (let i = 0; i < array.length; i += size) {
      chunks.push(array.slice(i, i + size));
    }
    return chunks;
  }

  getWeeks(): any[][] {
    const weeks = [];
    const chunkSize = 7;
    const totalDays = this.viewDays.length;
    let currentWeek = [];
    for (let i = 0; i < totalDays; i++) {
      currentWeek.push(this.viewDays[i]);
      if (currentWeek.length === chunkSize || i === totalDays - 1) {
        weeks.push(currentWeek);
        currentWeek = [];
      }
    }
    return weeks;
  }

  isToday(day: CalendarMonthViewDay): boolean {
    return isSameDay(day.date, new Date());
  }

  isSelected(day: CalendarMonthViewDay): boolean {
    return isSameDay(day.date, this.selectedDate);
  }

  previousMonth() {
    this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1);
  }

  nextMonth() {
    this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1);
  }

  formatDate(date: Date, format: string): string {
    return formatDate(date, format, 'es'); // Ajusta el locale según tus necesidades
  }

  get viewDays(): CalendarMonthViewDay[] {
    const start = startOfMonth(this.viewDate);
    const end = endOfMonth(this.viewDate);
    const days: CalendarMonthViewDay[] = [];

    for (let date = start; date <= end; date = addDays(date, 1)) {
      const day: CalendarMonthViewDay = {
        date: date,
        day: date.getDate(),
        inMonth: isSameMonth(date, this.viewDate),
        isToday: isSameDay(date, new Date()),
        events: [], // Lista de eventos para el día (opcional)
        badgeTotal: 0, // Número de eventos para el día (opcional)
        isPast: date < new Date(), // Si el día es pasado (opcional)
        isFuture: date > new Date(), // Si el día es futuro (opcional)
        isWeekend: [0, 6].includes(date.getDay()) // Si el día es fin de semana (opcional)
      };
      days.push(day);
    }

    return days;
  }

  dayClicked({ day }: { day: CalendarMonthViewDay }): void {
    // Lógica para manejar el evento de clic en un día del calendario
    console.log('Día clickeado:', day.date);
  }

  selectDate(date: Date): void {
    this.selectedDate = date;
    // Aquí puedes realizar acciones adicionales al seleccionar una fecha
  }

  selectDay(day: Date): void {
    this.selectedDay = day;
  }
  getLastDayOfPreviousMonth(): number {
    const previousMonth = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 0);
    return previousMonth.getDate();
  }

  getFirstDayOfWeek(): number {
    const firstDayOfMonth = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 1);
    let dayOfWeek = firstDayOfMonth.getDay() - 1; // Restamos 1 para que 0 represente el lunes

    if (dayOfWeek === -1) {
      dayOfWeek = 6; // Si el primer día del mes es domingo, ajustamos el valor para que 6 represente el lunes
    }

    return dayOfWeek;
  }

  getFirstDayOfNextMonth(): number {
    const nextMonth = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, 1);
    return nextMonth.getDay();
  }
}
