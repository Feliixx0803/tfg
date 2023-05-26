import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'incio-sesion',
  templateUrl: './incio-sesion.component.html',
  styleUrls: ['./incio-sesion.component.scss']
})
export class IncioSesionComponent {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }
 
  // login() {
  //   this.http.post('/usuario/find/{id}', username:this.username, )
  // }
  
}
