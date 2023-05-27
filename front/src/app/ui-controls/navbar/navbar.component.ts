import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { EventEmitterService } from "src/app/services/eventEmitter/event-emitter.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  usuarioRegistrado: boolean = false;
  nombreUsuario: string | null = "";

  constructor(private router: Router, private eventEmitterService: EventEmitterService){
    this.eventEmitterService.eventoLogin.subscribe((datos: any) => {
      this.loginUsuario(datos.nombreUsuario);
    })
  }

  ngOnInit(){
    if(localStorage.getItem("usuario")!=null){
      this.usuarioRegistrado = true;
      this.nombreUsuario = localStorage.getItem("usuario");
    }
  }

  public logout(): void{
    console.log("logout");
    localStorage.removeItem("usuario");
    this.usuarioRegistrado = false;

    this.eventEmitterService.eventoLogout.emit({usuario: localStorage.getItem("usuario")});
    this.router.navigate(['/login']);
  }

  loginUsuario(nombreUsuario: string): void{
    console.log("USUARIO LOGIN");
    this.nombreUsuario = nombreUsuario;
    this.usuarioRegistrado = true;
  }
}
