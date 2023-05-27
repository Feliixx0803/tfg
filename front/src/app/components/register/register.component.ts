import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../ventana-error/ventana-error.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  nombre: string;
  email: string;
  telefono: number;
  pwd: string;

  constructor(public http: HttpClient, private router: Router, private dialogRef: MatDialog) { }

  register(): void{
    let nombre = this.nombre;
    let email = this.email;
    let telefono = this.telefono;
    let pwd = this.pwd;

    let body = {
      nombre: nombre,
      email: email,
      telefono: telefono,
      pwd: pwd
    }

    this.http.post('http://localhost:8080/register', body, { 'responseType': 'text' }).subscribe(
      (response) => this.router.navigate(["/login"]),
      (error) => this.open(error.error)
    );
  }

  open(texto: String) {
    this.dialogRef.open(VentanaErrorComponent, {
      height: '250px',
      width: '380px',
      data: {
        texto: texto
      }
    });
  }
}
