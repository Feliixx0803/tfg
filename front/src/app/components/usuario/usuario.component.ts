import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import {DatosUsuario, UsuarioServiceService} from "../../services/usuario/usuario-service.service";
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {EventEmitterService} from "../../services/eventEmitter/event-emitter.service";
import { EventoModel } from 'src/app/models/evento/evento-model';

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit{

  datosUsuario: DatosUsuario;

  inscripciones: string[];
  eventosGestionados: string[];

  nombreUsuario: string;
  emailUsuario: string;
  telefonoUsuario: string;

  constructor(
    public ruta: ActivatedRoute,
    private usuarioService : UsuarioServiceService,
    private eventEmitterService : EventEmitterService,
    private router: Router
  ) { }

  ngOnInit() {
    const nombre = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarUsuario(nombre).then(() => {
      this.nombreUsuario = this.datosUsuario.nombre;
      this.emailUsuario = this.datosUsuario.email;
      this.telefonoUsuario = this.datosUsuario.telefono;
      console.log(this.datosUsuario);
    });

    this.rellenarInscripciones(nombre).then(() => console.log(this.inscripciones));
    this.rellenarGestionados(nombre).then(() => console.log(this.eventosGestionados));;
  }

  async rellenarInscripciones(nombre: string | null) {
    this.inscripciones = await lastValueFrom(this.usuarioService.getEventosInscritos(nombre));
  }

  async rellenarGestionados(nombre: string | null) {
    this.eventosGestionados = await lastValueFrom(this.usuarioService.getEventosGestionados(nombre));
  }

  async encontrarUsuario(nombre: string | null){
    this.datosUsuario = await lastValueFrom(this.usuarioService.getDatosPaginaUsuario(nombre).pipe());
  }

  async cambiarDatos(){
    const nombre = this.nombreUsuario;
    const email = this.emailUsuario;
    const telefono = this.telefonoUsuario;

    if (nombre) {
      this.datosUsuario.nombre = nombre;
    }
    if (email) {
      this.datosUsuario.email = email;
    }
    if (telefono) {
      this.datosUsuario.telefono = telefono;
    }

    console.log(nombre + ", " + email + ", " + telefono);

    let datosUsuarioUpdate = {
      nombre: nombre,
      email: email,
      telefono: telefono,
      //Rol por defecto
      nombreRol: 'user'
    }

    let nombreUsuarioActual = localStorage.getItem('usuario');
    let idUsuario: number = await lastValueFrom(this.usuarioService.getIdByNombre(nombreUsuarioActual).pipe());

    this.usuarioService.updateUsuario(datosUsuarioUpdate, idUsuario)
      .subscribe((datosUsuario)=>{
        this.eventEmitterService.eventoUsuarioActualizado.emit(datosUsuario);
        localStorage.setItem('usuario', datosUsuario.nombre);
        this.router.navigate(["/usuario", localStorage.getItem('usuario')]);
      });
  }
}
