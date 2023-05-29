import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UsuarioModel } from 'src/app/models/usuario/usuario-model';
import { EventEmitterService } from 'src/app/services/eventEmitter/event-emitter.service';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../ventana-error/ventana-error.component';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  email: string = "";
  pwd: string = "";

  constructor(public http: HttpClient, public eventEmitterService: EventEmitterService, public dialogRef: MatDialog, private router: Router){}

  public login():void {
    let email = this.email;
    let pwd = this.pwd;

    let body = {
      email: email,
      pwd: pwd
    }

    this.http.post<UsuarioModel>('http://localhost:8080/login', body, {responseType: 'json'}).subscribe(
      (response) => {
        this.validarLogin(response);
        this.router.navigate(["/home"])
      },
      (error) => this.open(error.error)
    );
  }

  validarLogin(response: UsuarioModel): void{
    console.log(response.nombre);
    localStorage.setItem('usuario', response.nombre);
    this.eventEmitterService.eventoLogin.emit({nombreUsuario: localStorage.getItem("usuario")});

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
