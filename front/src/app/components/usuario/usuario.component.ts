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

  /**
   * Crea una instancia del componente UsuarioComponent.
   * @param ruta - Instancia de ActivatedRoute utilizada para obtener el parámetro de la ruta.
   * @param usuarioService - Instancia de UsuarioServiceService utilizada para obtener y actualizar los datos del usuario.
   * @param eventEmitterService - Instancia de EventEmitterService utilizada para emitir eventos relacionados con el usuario.
   * @param router - Instancia de Router utilizada para la navegación.
   */
  constructor(
    public ruta: ActivatedRoute,
    private usuarioService : UsuarioServiceService,
    private eventEmitterService : EventEmitterService,
    private router: Router
  ) { }

  /**
   * Se ejecuta al inicializar el componente.
   * Obtiene los datos del usuario, las inscripciones y los eventos gestionados.
   */
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

  /**
   * Rellena las inscripciones del usuario.
   * @param nombre - Nombre del usuario.
   */
  async rellenarInscripciones(nombre: string | null) {
    this.inscripciones = await lastValueFrom(this.usuarioService.getEventosInscritos(nombre));
  }

  /**
   * Rellena los eventos gestionados por el usuario.
   * @param nombre - Nombre del usuario.
   */
  async rellenarGestionados(nombre: string | null) {
    this.eventosGestionados = await lastValueFrom(this.usuarioService.getEventosGestionados(nombre));
  }


  /**
   * Busca y establece los datos del usuario.
   * @param nombre - Nombre del usuario.
   */
  async encontrarUsuario(nombre: string | null){
    this.datosUsuario = await lastValueFrom(this.usuarioService.getDatosPaginaUsuario(nombre).pipe());
  }

  /**
   * Cambia los datos del usuario.
   */
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
