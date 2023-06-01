import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {EventoService} from "../../../services/evento/evento.service";
import {EventoModel} from "../../../models/evento/evento-model";
import {UsuarioServiceService} from "../../../services/usuario/usuario-service.service";
import {UsuarioModel} from "../../../models/usuario/usuario-model";
import { lastValueFrom } from 'rxjs';
import {MatDialog} from "@angular/material/dialog";
import {VentanaErrorComponent} from "../../ventana-error/ventana-error.component";
import {ValidadorFechasService} from "../../../services/validadorFechas/validador-fechas.service";

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

  constructor(
    private router:Router,
    public eventoService: EventoService,
    public usuarioService:UsuarioServiceService,
    public dialogRef: MatDialog,
    public validarFechas : ValidadorFechasService) {}

  registrarEvento() {

    this.encontrarUsuario().then(() => {

      if (
        !this.validarFechas.validarAnio(this.fechaInicio) ||
        !this.validarFechas.validarAnio(this.fechaFin)
      ) {
        this.open("Por favor, introduce fechas válidas");
        return;
      }

      if(!this.validarFechas.validarFecha(this.fechaInicio)){
        this.open("Fecha incorrecta");
        return;
      }

      if (this.fechaInicio > this.fechaFin) {
        this.open("La fecha de inicio no puede ser posterior a la fecha de fin");
        return;
      }

      if (!this.nombre || !this.fechaInicio || !this.fechaFin || !this.descripcion) {
        this.open("Todos los campos son obligatorios");
        return;
      }

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
        console.log(error.error);
        this.open("Nombre de evento ya existe");
      });
    });
  }

  async encontrarUsuario(){
    this.usuarioLogeado = await lastValueFrom(this.usuarioService.getUserByNombre(localStorage.getItem('usuario')).pipe());
  }

  open(texto: String){
    this.dialogRef.open(VentanaErrorComponent, {
      height: '250px',
      width: '380px',
      data: {
        texto: texto
      }
    });
  }
}
