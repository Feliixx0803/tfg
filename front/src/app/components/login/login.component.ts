import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UsuarioModel } from 'src/app/models/usuario/usuario-model';
import { EventEmitterService } from 'src/app/services/eventEmitter/event-emitter.service';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../ventana-error/ventana-error.component';
import { Router } from '@angular/router';
import { DatosUsuario } from 'src/app/services/usuario/usuario-service.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  email: string = "";
  pwd: string = "";

  /**
   * Crea una instancia del componente LoginComponent.
   * @param http - Instancia de HttpClient utilizada para realizar solicitudes HTTP.
   * @param eventEmitterService - Instancia de EventEmitterService utilizada para emitir eventos relacionados con el inicio de sesión.
   * @param dialogRef - Instancia de MatDialog utilizada para abrir un diálogo de error.
   * @param router - Instancia de Router utilizada para la navegación a diferentes rutas.
   */
  constructor(public http: HttpClient,
              public eventEmitterService: EventEmitterService,
              public dialogRef: MatDialog,
              private router: Router){}

  /**
   * Realiza el inicio de sesión.
   */
  public login():void {
    let email = this.email;
    let pwd = this.pwd;

    let body = {
      email: email,
      pwd: pwd
    }

    this.http.post<DatosUsuario>('http://localhost:8080/login', body, {responseType: 'json'}).subscribe(
      (response) => {
        this.validarLogin(response);
        this.router.navigate(["/home"])
      },
      (error) => this.open(error.error)
    );
  }

  /**
   * Valida el inicio de sesión y realiza acciones en consecuencia.
   * @param response - La respuesta del servidor con los datos del usuario.
   */
  validarLogin(response: DatosUsuario): void{
    console.log(response.nombre);
    localStorage.setItem('usuario', response.nombre);
    this.eventEmitterService.eventoLogin.emit({nombreUsuario: localStorage.getItem("usuario")});

  }

  /**
   * Abre un diálogo de error con el mensaje especificado.
   * @param texto - El mensaje de error.
   */
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
