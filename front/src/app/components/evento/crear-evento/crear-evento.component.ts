import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EventoService } from '../../../services/evento/evento.service';
import { EventoModel } from '../../../models/evento/evento-model';
import { UsuarioServiceService } from '../../../services/usuario/usuario-service.service';
import { UsuarioModel } from '../../../models/usuario/usuario-model';
import { lastValueFrom } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../../ventana-error/ventana-error.component';
import { ValidadorFechasService } from '../../../services/validadorFechas/validador-fechas.service';

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
  //imagenSeleccionada: File;
  ubicacion: string; 

  usuarioLogeado: UsuarioModel;

  constructor(
    private router: Router,
    public eventoService: EventoService,
    public usuarioService: UsuarioServiceService,
    public dialogRef: MatDialog,
    public validarFechas: ValidadorFechasService
  ) {}

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
      /*else if (this.imagenSeleccionada.size >= 1048576) {
        this.open('Todos los campos son obligatorios');
        return;
      }*/
      else{

        /*const formData = new FormData();

        console.log(this.fechaInicio);
        console.log(this.fechaFin);

        formData.append('nombre', this.nombre);
        formData.append('fechaInicio', new Date(this.fechaInicio).toISOString());
        formData.append('fechaFin', new Date(this.fechaFin).toISOString());
        formData.append('descripcion', this.descripcion); 
        formData.append('imagen', this.imagenSeleccionada, this.imagenSeleccionada.name);
        formData.append('gestor', JSON.stringify(this.usuarioLogeado));

        this.nuevoEvento(formData).then((evento) => {
          console.log(evento); 
        });*/

        const eventoNuevo: EventoModel = {
          nombre: this.nombre,
          fechaInicio: this.fechaInicio,
          fechaFin: this.fechaFin,
          descripcion: this.descripcion,
          //imagen: this.imagenSeleccionada,
          ubicacion: this.ubicacion,
          gestor: this.usuarioLogeado
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

  async encontrarUsuario() {
    this.usuarioLogeado = await lastValueFrom(
      this.usuarioService.getUserByNombre(localStorage.getItem('usuario')).pipe()
    );
  }

  open(texto: string) {
    this.dialogRef.open(VentanaErrorComponent, {
      height: '250px',
      width: '380px',
      data: {
        texto: texto
      }
    });
  }

  /*onFileSelected(fileInput: any) {
    this.imagenSeleccionada = fileInput.target.files[0];
  }

  onUpload() {
    if (this.imagenSeleccionada) {
      const formData = new FormData();
      formData.append('imagen', this.imagenSeleccionada);
    }
  }

  async nuevoEvento(formData: FormData){
    return await lastValueFrom(this.eventoService.addEvento(formData));
  }*/
}
