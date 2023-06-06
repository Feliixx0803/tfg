import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import {UsuarioServiceService} from "../../services/usuario/usuario-service.service";
import { ActivatedRoute } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {EventEmitterService} from "../../services/eventEmitter/event-emitter.service";

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit{

  usuario: UsuarioModel = new UsuarioModel();

  nombreUsuario: string;
  emailUsuario: string;
  telefonoUsuario: string;

  constructor(
    public ruta: ActivatedRoute,
    private usuarioService : UsuarioServiceService,
    private http: HttpClient,
    private eventEmitterService : EventEmitterService
  ) { }

  ngOnInit() {
    const nombre = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarUsuario(nombre).then(() => {
      console.log(this.usuario);
    });
  }

  async encontrarUsuario(nombre: string | null){
    this.usuario = await lastValueFrom(this.usuarioService.getUserByNombre(nombre).pipe());
  }

  cambiarDatos(){
    const nombre = this.nombreUsuario;
    const email = this.emailUsuario;
    const telefono = this.telefonoUsuario;

    if (nombre) {
      this.usuario.nombre = nombre;
    }
    if (email) {
      this.usuario.email = email;
    }
    if (telefono) {
      this.usuario.telefono = telefono;
    }

    this.http.put<UsuarioModel>('http://localhost:8080/usuario/update',this.usuario)
      .subscribe(()=>{
        this.eventEmitterService.eventoUsuarioActualizado.emit(this.usuario);
      });
  }
}
