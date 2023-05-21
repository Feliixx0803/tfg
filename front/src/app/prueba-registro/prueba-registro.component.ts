import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'prueba-registro',
  templateUrl: './prueba-registro.component.html',
  styleUrls: ['./prueba-registro.component.scss']
})
export class PruebaRegistroComponent {
  nombre: string="";
  email: string="";
  telefono: string="";
  pwd: string="";

  constructor(private http: HttpClient){ }

  registro(): void{
    let nombre = this.nombre;
    let email = this.email;
    let telefono = this.telefono;
    let pwd = this.pwd;

    //TODO: validación de contraseña

    let body = {
      "nombre": nombre, 
      "email": email, 
      "telefono": telefono,
      "pwd": pwd,
      "rol": {
        "id": 1
      }
    };

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    this.http.post("http://localhost:8080/usuario/add", body, httpOptions).subscribe((response) => {console.log(response)})
  }
}
