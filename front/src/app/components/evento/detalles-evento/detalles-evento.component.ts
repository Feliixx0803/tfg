import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { EventoModel } from 'src/app/models/evento/evento-model';
import { EventoService } from 'src/app/services/evento/evento.service';

@Component({
  selector: 'app-detalles-evento',
  templateUrl: './detalles-evento.component.html',
  styleUrls: ['./detalles-evento.component.scss']
})
export class DetallesEventoComponent implements OnInit{
  eventoSeleccionado: EventoModel = new EventoModel();

  constructor(public ruta: ActivatedRoute, public eventoService: EventoService){}

  ngOnInit(){
    const nombreEvento = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarEvento(nombreEvento).then(() => {
      console.log(this.eventoSeleccionado);
    });
  }

  async encontrarEvento(nombreEvento: string | null){
    this.eventoSeleccionado = await lastValueFrom(this.eventoService.findEventoByNombre(nombreEvento).pipe());
  }
}
