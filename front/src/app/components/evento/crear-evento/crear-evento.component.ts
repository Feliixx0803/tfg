import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {EventoService} from "../../../services/evento/evento.service";
import {EventoModel} from "../../../models/evento/evento-model";
import {UsuarioServiceService} from "../../../services/usuario/usuario-service.service";
import {UsuarioModel} from "../../../models/usuario/usuario-model";
import { lastValueFrom } from 'rxjs';

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

  usuarioLogeado: UsuarioModel;

  constructor(private router:Router, public eventoService: EventoService, public usuarioService:UsuarioServiceService) {}

  registrarEvento() {

    this.encontrarUsuario().then(() => {
      const eventoNuevo: EventoModel = {
        nombre: this.nombre,
        fechaInicio: this.fechaInicio,
        fechaFin: this.fechaFin,
        descripcion: this.descripcion,
        gestor: this.usuarioLogeado
      };

      this.eventoService.createEvento(eventoNuevo).subscribe(
      (response)=>{
        console.log('Evento creado:', response);
        this.router.navigate(['/evento']);
      }, 
      (error)=>{
        console.error('Error al crear evento:', error);
      });
    });
  }

  async encontrarUsuario(){
    this.usuarioLogeado = await lastValueFrom(this.usuarioService.getUserByNombre(localStorage.getItem('usuario')).pipe());
  }
}
