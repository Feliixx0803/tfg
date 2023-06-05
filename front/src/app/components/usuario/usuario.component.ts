import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import {UsuarioServiceService} from "../../services/usuario/usuario-service.service";
import { ActivatedRoute } from '@angular/router';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit{

  usuario: UsuarioModel = new UsuarioModel();

  emailUsuario: string;
  telefonoUsuario: string;

  constructor(public ruta: ActivatedRoute, private usuarioService : UsuarioServiceService) { }

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
    let email = this.emailUsuario;
    let telefono = this.telefonoUsuario;

    //TODO: hacer cambio de datos (datosDTO, metodo en backend, mostrar aqui)
  }
}
