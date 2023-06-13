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

  /**
   * Crea una instancia del componente `NavbarComponent`.
   * @param router El enrutador de la aplicación.
   * @param eventEmitterService El servicio EventEmitterService para la comunicación entre componentes.
   */
  constructor(private router: Router, private eventEmitterService: EventEmitterService){
    this.eventEmitterService.eventoLogin.subscribe((datos: any) => {
      this.loginUsuario(datos.nombreUsuario);
    })
    this.eventEmitterService.eventoUsuarioActualizado.subscribe(usuario =>{
      this.nombreUsuario = usuario.nombre;
    })
  }

  /**
   * Se ejecuta al inicializar el componente.
   */
  ngOnInit(){
    if(localStorage.getItem("usuario")!=null){
      this.usuarioRegistrado = true;
      this.nombreUsuario = localStorage.getItem("usuario");
    }
  }


  /**
   * Cierra la sesión del usuario.
   */
  public logout(): void{
    console.log("logout");
    localStorage.removeItem("usuario");
    this.usuarioRegistrado = false;

    this.eventEmitterService.eventoLogout.emit({usuario: localStorage.getItem("usuario")});
    this.router.navigate(['/home']);
  }

  /**
   * Maneja el evento de inicio de sesión de usuario.
   * @param nombreUsuario El nombre del usuario que inició sesión.
   */
  loginUsuario(nombreUsuario: string): void{
    console.log("USUARIO LOGIN");
    this.nombreUsuario = nombreUsuario;
    this.usuarioRegistrado = true;
  }
}
