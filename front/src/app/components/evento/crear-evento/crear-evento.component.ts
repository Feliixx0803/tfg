import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EventoService } from '../../../services/evento/evento.service';
import { EventoModel } from '../../../models/evento/evento-model';
import { DatosUsuario, UsuarioServiceService } from '../../../services/usuario/usuario-service.service';
import { UsuarioModel } from '../../../models/usuario/usuario-model';
import { lastValueFrom } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../../ventana-error/ventana-error.component';
import { ValidadorFechasService } from '../../../services/validadorFechas/validador-fechas.service';

/**
 * Interfaz para crear un EventoDTO
 */
export interface CrearEventoDTO{
  nombre: string;
  fechaInicio: Date;
  fechaFin: Date;
  descripcion: string;
  ubicacion: string;
  idGestor: number;
}

@Component({
  selector: 'app-crear-evento',
  templateUrl: './crear-evento.component.html',
  styleUrls: ['./crear-evento.component.scss']
})
export class CrearEventoComponent {
  nombre: string;
  fechaInicio: Date;
  fechaFin: Date;
  descripcion: string;
  ubicacion: string;

  usuarioLogeado: DatosUsuario;

  /**
   * Constructor del componente.
   * @param eventoService Servicio para acceder a los datos de los eventos
   * @param usuarioService Servicio para acceder a los datos de los usuarios
   * @param router Objeto Router para redirigir a otras rutas
   * @param dialogRef Objeto MatDialog para abrir un diálogo
   * @param validarFechas Servicio para validar las fechas del evento
   */
  constructor(
    private router: Router,
    public eventoService: EventoService,
    public usuarioService: UsuarioServiceService,
    public dialogRef: MatDialog,
    public validarFechas: ValidadorFechasService
  ) {}

  /**
   * Registra un nuevo evento.
   * Contiene las validaciones para cada campo.
   */
  registrarEvento() {
    this.encontrarUsuario().then(() => {
      if (
        !this.validarFechas.validarAnio(this.fechaInicio) ||
        !this.validarFechas.validarAnio(this.fechaFin)
      ) {
        this.open('Por favor, introduce fechas válidas');
        return;
      }
      else if (!this.validarFechas.validarFecha(this.fechaInicio)) {
        this.open('Fecha incorrecta');
        return;
      }
      else if (this.fechaInicio > this.fechaFin) {
        this.open('La fecha de inicio no puede ser posterior a la fecha de fin');
        return;
      }
      else if (!this.nombre || !this.fechaInicio || !this.fechaFin || !this.descripcion || !this.ubicacion) {
        this.open('Todos los campos son obligatorios');
        return;
      }

      else{
        let idUsuario: number = 0;

        this.encontrarIdUsuario().then(id => {
          idUsuario = id;

          if(idUsuario != 0){
            const eventoNuevo: CrearEventoDTO = {
              nombre: this.nombre,
              fechaInicio: this.fechaInicio,
              fechaFin: this.fechaFin,
              descripcion: this.descripcion,
              ubicacion: this.ubicacion,
              idGestor: idUsuario,
            };

            this.eventoService.createEvento(eventoNuevo).subscribe(
              () => {
                this.router.navigate(['/evento']);
              },
              (error) => {
                console.log(error.error);
                this.open('Nombre de evento ya existe');
              }
            );
          }
        });


      }


    });
  }
  /**
   * Obtiene los datos del usuario logeado.
   */
  async encontrarUsuario() {
    this.usuarioLogeado = await lastValueFrom(this.usuarioService.getUserByNombre(localStorage.getItem('usuario')).pipe());
  }
  /**
   * Obtiene el ID del usuario logeado.
   * @returns El ID del usuario logeado.
   */
  async encontrarIdUsuario(){
    return await lastValueFrom(this.usuarioService.getIdByNombre(this.usuarioLogeado.nombre).pipe());
  }

  /**
   * Abre un diálogo de error con el mensaje especificado.
   * @param texto El mensaje de error.
   */
  open(texto: string) {
    this.dialogRef.open(VentanaErrorComponent, {
      height: '250px',
      width: '380px',
      data: {
        texto: texto
      }
    });
  }

}
