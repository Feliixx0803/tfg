import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-autenticacion',
  templateUrl: './autenticacion.component.html',
  styleUrls: ['./autenticacion.component.scss']
})
export class AutenticacionComponent {
  email: string="";

  constructor(private http: HttpClient, private router: Router){

  }
  enviarLogin(): void{
    let email = this.email;
    
    alert(email);
  }
  redirectToRegistration() {
    this.router.navigate(['/registro']);
  }
}
