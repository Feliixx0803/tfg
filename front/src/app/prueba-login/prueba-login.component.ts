import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'prueba-login',
  templateUrl: './prueba-login.component.html',
  styleUrls: ['./prueba-login.component.scss']
})
export class PruebaLoginComponent {
  email: string="";

  constructor(private http: HttpClient){

  }

  enviarLogin(): void{
    let email = this.email;
    
    alert(email);
  }
}
