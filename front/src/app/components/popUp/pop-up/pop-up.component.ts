import {Component, OnInit} from '@angular/core';
import {UsuarioModel} from "../../../models/usuario/usuario-model";
import {UsuarioServiceService} from "../../../services/usuario/usuario-service.service";
import {lastValueFrom} from "rxjs";

@Component({
  selector: 'pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.scss']
})
export class PopUpComponent implements OnInit{

  nombreUsuario : string | null;

  constructor(public usuarioService :UsuarioServiceService) {
  }

  /*async encontrarUsuario(){
    this.nombreUsuario = await lastValueFrom(this.usuarioService.getUserByNombre(localStorage.getItem('usuario')).pipe());
    console.log(this.nombreUsuario);
  }*/

  ngOnInit() {
    //this.encontrarUsuario();
    this.nombreUsuario = localStorage.getItem("usuario");
  }

}
