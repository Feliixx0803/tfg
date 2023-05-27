import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../models/usuario/usuario-model";
import {UsuarioServiceService} from "../../services/usuario/usuario-service.service";
import {RolModel} from "../../models/rol/rol-model";

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit{

  usuarios :UsuarioModel[];
  nuevoUsuario : UsuarioModel;

  constructor(private usuarioServicio : UsuarioServiceService) { }

  ngOnInit() {
    this.getAllUsuarios();
  }

  //Recibir todos los empleados:
  private getAllUsuarios(){
    this.usuarioServicio.getAllUsuarios().subscribe(usuario =>{
      this.usuarios = usuario;
    })
  }

  private createUsuario(){
    this.usuarioServicio.createUser(this.nuevoUsuario).subscribe();
  }

  /*private updateUsuario(){
    this.usuarioServicio.updateUsuario(this.usuarioId,this.usuario).subscribe();
  }*/

  private deleteUsuario(usuarioId:number){
    this.usuarioServicio.deleteUsuario(usuarioId).subscribe();
  }
}
