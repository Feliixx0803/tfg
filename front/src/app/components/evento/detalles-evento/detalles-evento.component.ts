import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom, tap } from 'rxjs';
import { EstadoModel } from 'src/app/models/estado/estado-model';
import { EventoModel } from 'src/app/models/evento/evento-model';
import { InscripcionModel } from 'src/app/models/inscripcion/inscripcion-model';
import { UsuarioModel } from 'src/app/models/usuario/usuario-model';
import { EstadoService } from 'src/app/services/estado/estado.service';
import { EventoService } from 'src/app/services/evento/evento.service';
import { InscripcionService } from 'src/app/services/inscripcion/inscripcion.service';
import { DatosUsuario, UsuarioServiceService } from 'src/app/services/usuario/usuario-service.service';
import { VentanaErrorComponent } from '../../ventana-error/ventana-error.component';

export interface InscripcionDTO {
  idEvento: number;
  idUsuario: number;
  fecha: Date;
  idEstado: number;
}

@Component({
  selector: 'app-detalles-evento',
  templateUrl: './detalles-evento.component.html',
  styleUrls: ['./detalles-evento.component.scss']
})
export class DetallesEventoComponent implements OnInit {
  eventoSeleccionado: EventoModel;

  /**
   * Constructor del componente.
   * @param ruta Objeto ActivatedRoute para obtener los parámetros de la URL
   * @param eventoService Servicio para acceder a los datos de los eventos
   * @param inscripcionService Servicio para realizar la inscripción de un usuario
   * @param estadoService Servicio para acceder a los datos de los estados
   * @param usuarioService Servicio para acceder a los datos de los usuarios
   * @param router Objeto Router para redirigir a otras rutas
   * @param dialogRef Objeto MatDialog para abrir un diálogo
   */
  constructor(public ruta: ActivatedRoute,
    public eventoService: EventoService,
    private inscripcionService: InscripcionService,
    private estadoService: EstadoService,
    private usuarioService: UsuarioServiceService,
    private router: Router,
    public dialogRef: MatDialog) { }

  /**
   * Método que se ejecuta al inicializar el componente.
   * Obtiene el nombre del evento de los parámetros de la URL y busca el evento correspondiente.
   */
  ngOnInit() {
    const nombreEvento = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarEvento(nombreEvento).then(() => {
      console.log(this.eventoSeleccionado);
    });
  }

  /**
   * Método asincrónico para buscar un evento por su nombre.
   * @param nombreEvento Nombre del evento a buscar
   */
  async encontrarEvento(nombreEvento: string | null) {
    this.eventoSeleccionado = await lastValueFrom(this.eventoService.findEventoByNombre(nombreEvento).pipe());
  }

  /**
   * Método asincrónico para inscribir a un usuario en un evento.
   * Verifica si el usuario ya está inscrito y realiza la inscripción si no hay repeticiones.
   */
  async inscribirUsuario() {
    const nombreUsuario = localStorage.getItem('usuario');

    if (nombreUsuario) {
      let idUsuario = await lastValueFrom(this.usuarioService.getIdByNombre(nombreUsuario).pipe());
      console.log(idUsuario);

      let idEvento = await lastValueFrom(this.eventoService.getIdByNombre(this.eventoSeleccionado.nombre).pipe());
      console.log(idEvento);

      let inscripcionRepetida = await lastValueFrom(this.inscripcionService.comprobarRepeticiones(idEvento, idUsuario).pipe());

      if(!inscripcionRepetida){

        let fecha = new Date();
      console.log(fecha);

      let idEstado = 1;

      let inscripcionDTO: InscripcionDTO = {
        idEvento: idEvento,
        idUsuario: idUsuario,
        fecha: fecha,
        idEstado: idEstado
      }
      await lastValueFrom(this.inscripcionService.inscribirUsuarioDTO(inscripcionDTO).pipe()).then(() => this.router.navigate(['/usuario', localStorage.getItem('usuario')]));
      }
      else{
        this.open("INSCRIPCION REPETIDA");
      }
    }
    else {
      this.router.navigate(['/login']);
    }
  }

  /**
   * Método para abrir un diálogo con un mensaje de error.
   * @param texto Texto a mostrar en el diálogo
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
