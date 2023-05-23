import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import {UsuarioServiceService} from "../../services/usuario/usuario-service.service";

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit{

  usuarios :UsuarioModel[];

  constructor(private usuarioServicio : UsuarioServiceService) { }

  ngOnInit() {
    this.getAllUsuarios()
  }

  //Recibir todos los empleados:
  private getAllUsuarios(){
    this.usuarioServicio.getAllUsuarios().subscribe(usuario =>{
      this.usuarios = usuario;
    })
  }
}
