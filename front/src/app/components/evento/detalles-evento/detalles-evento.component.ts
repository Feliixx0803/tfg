import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { lastValueFrom, tap } from 'rxjs';
import { EstadoModel } from 'src/app/models/estado/estado-model';
import { EventoModel } from 'src/app/models/evento/evento-model';
import { InscripcionModel } from 'src/app/models/inscripcion/inscripcion-model';
import { UsuarioModel } from 'src/app/models/usuario/usuario-model';
import { EstadoService } from 'src/app/services/estado/estado.service';
import { EventoService } from 'src/app/services/evento/evento.service';
import { InscripcionService } from 'src/app/services/inscripcion/inscripcion.service';

@Component({
  selector: 'app-detalles-evento',
  templateUrl: './detalles-evento.component.html',
  styleUrls: ['./detalles-evento.component.scss']
})
export class DetallesEventoComponent implements OnInit{
  eventoSeleccionado: EventoModel = new EventoModel();

  constructor(public ruta: ActivatedRoute, public eventoService: EventoService, private inscripcionService: InscripcionService, private estadoService: EstadoService){}

  ngOnInit(){
    const nombreEvento = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarEvento(nombreEvento).then(() => {
      console.log(this.eventoSeleccionado);
    });
  }

  async encontrarEvento(nombreEvento: string | null){
    this.eventoSeleccionado = await lastValueFrom(this.eventoService.findEventoByNombre(nombreEvento).pipe());
  }

  inscribirUsuario() {
    const usuarioLogado = localStorage.getItem('usuario');
    let usuario: UsuarioModel | null = null;
    const nombreEstado = 'Inscrito';
  
    // Verificar el estado "Inscrito"
    this.estadoService.verificarEstadoInscrito(nombreEstado).pipe(
      tap((estado: EstadoModel) => {
        // Si el estado "Inscrito" existe, realiza la inscripción
        if (estado) {
          // Obtener el usuario logado
          if (usuarioLogado) {
            usuario = JSON.parse(usuarioLogado) as UsuarioModel;
          }
  
          // Realizar la inscripción con el estado "Inscrito"
          if (usuario) {
            const inscripcion: InscripcionModel = {
              fecha: new Date(),
              usuario: usuario,
              evento: this.eventoSeleccionado,
              estado: estado,
            };
  
            this.realizarInscripcion(inscripcion);
          }
        } else {
          // Si el estado "Inscrito" no existe, crearlo y luego realizar la inscripción
          const nuevoEstado: EstadoModel = {
            nombre: nombreEstado
          };
  
          this.estadoService.crearEstadoInscrito().pipe(
            tap((estadoCreado: EstadoModel) => {
              // Obtener el usuario logado
              if (usuarioLogado) {
                usuario = JSON.parse(usuarioLogado) as UsuarioModel;
              }
  
              // Realizar la inscripción con el estado "Inscrito" creado
              if (usuario) {
                const inscripcion: InscripcionModel = {
                  fecha: new Date(),
                  usuario: usuario,
                  evento: this.eventoSeleccionado,
                  estado: estadoCreado,
                };
  
                this.realizarInscripcion(inscripcion);
              }
            })
          ).subscribe(
            () => {},
            error => {
              // Maneja el error si ocurre al crear el estado "Inscrito"
            }
          );
        }
      })
    ).subscribe(
      () => {},
      error => {
        // Maneja el error si ocurre al verificar el estado "Inscrito"
      }
    );
  }
  
  realizarInscripcion(inscripcion: InscripcionModel) {
    this.inscripcionService.inscribirUsuario(inscripcion);
  }
  
}