import { Component, OnInit } from '@angular/core';
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

export interface InscripcionDTO{
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
export class DetallesEventoComponent implements OnInit{
  eventoSeleccionado: EventoModel;

  constructor(public ruta: ActivatedRoute,
    public eventoService: EventoService,
    private inscripcionService: InscripcionService,
    private estadoService: EstadoService,
    private usuarioService: UsuarioServiceService,
    private router: Router){}

  ngOnInit(){
    const nombreEvento = this.ruta.snapshot.paramMap.get('nombre');

    this.encontrarEvento(nombreEvento).then(() => {
      console.log(this.eventoSeleccionado);
    });
  }

  async encontrarEvento(nombreEvento: string | null){
    this.eventoSeleccionado = await lastValueFrom(this.eventoService.findEventoByNombre(nombreEvento).pipe());
  }

  /*inscribirUsuario() {
    const nombreUsuario = localStorage.getItem('usuario');
    let usuario: UsuarioModel | null = null;
    const nombreEstado = 'Inscrito';

    // Verificar el estado "Inscrito"
    this.estadoService.verificarEstadoInscrito(nombreEstado).pipe(
      tap(async (estado: EstadoModel) => {
        // Si el estado "Inscrito" existe, realiza la inscripción
        if (estado) {
          console.log("ESTADO INSCRITO EXISTE");
          // Obtener el usuario logado
          if (nombreUsuario) {
            usuario = await lastValueFrom(this.usuarioService.getUserByNombre(nombreUsuario).pipe());
          }

          // Realizar la inscripción con el estado "Inscrito"
          if (usuario) {
            const inscripcion: InscripcionModel = {
              fecha: new Date(),
              usuario: usuario,
              evento: this.eventoSeleccionado,
              estado: estado,
            };

            this.realizarInscripcion(inscripcion).then(inscripcionNueva => {
              console.log(inscripcionNueva);
            });
          }
        } else {
          console.log("ESTADO INSCRITO NO EXISTE");
          // Si el estado "Inscrito" no existe, crearlo y luego realizar la inscripción
          const nuevoEstado: EstadoModel = {
            nombre: nombreEstado
          };

          this.estadoService.crearEstadoInscrito().pipe(
            tap(async (estadoCreado: EstadoModel) => {
              // Obtener el usuario logado
              if (nombreUsuario) {
                usuario = await lastValueFrom(this.usuarioService.getUserByNombre(nombreUsuario).pipe());
              }

              // Realizar la inscripción con el estado "Inscrito" creado
              if (usuario) {
                const inscripcion: InscripcionModel = {
                  fecha: new Date(),
                  usuario: usuario,
                  evento: this.eventoSeleccionado,
                  estado: estadoCreado,
                };

                this.realizarInscripcion(inscripcion).then(inscripcionNueva => {
                  console.log(inscripcionNueva.usuario.inscripciones);
                });
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
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error.error);
        // Maneja el error si ocurre al verificar el estado "Inscrito"
      }
    );*/

    //ACTUALIZADO:
   /* const nombreEstado = 'En curso';
    let usuario :UsuarioModel;
    const nombreUsuario = localStorage.getItem('usuario');

    // Verificar el estado "en curso"
    this.estadoService.verificarEstadoInscrito(nombreEstado).pipe(
      tap(async (estado: EstadoModel) => {
        // Si el estado "En curso" existe, realiza la inscripción
        if (estado) {
          console.log("ESTADO En curso EXISTE");
          // Obtener el usuario logado
          if (nombreUsuario) {
            usuario = await lastValueFrom(this.usuarioService.getUserByNombreModel(nombreUsuario).pipe());
          }
          // Realizar la inscripción con el estado "en curso"
          if (usuario) {
            const inscripcion: InscripcionModel = {
              fecha: new Date(),
              usuario: usuario,
              evento: this.eventoSeleccionado,
              estado: estado,
            };


            this.realizarInscripcion(inscripcion).then(inscripcionNueva => {
              console.log(inscripcionNueva);
            });
          }
        } else {
          console.log("ESTADO en curso NO EXISTE");
          // Si el estado "en curso" no existe, crearlo y luego realizar la inscripción
          const nuevoEstado: EstadoModel = {
            nombre: nombreEstado
          };

          this.estadoService.crearEstadoInscrito().pipe(
            tap(async (estadoCreado: EstadoModel) => {
              // Obtener el usuario logado
              if (nombreUsuario) {
                usuario = await lastValueFrom(this.usuarioService.getUserByNombreModel(nombreUsuario).pipe());
              }

              // Realizar la inscripción con el estado "en curso" creado
              if (usuario) {
                const inscripcion: InscripcionModel = {
                  fecha: new Date(),
                  usuario: usuario,
                  evento: this.eventoSeleccionado,
                  estado: estadoCreado,
                };

                this.realizarInscripcion(inscripcion).then(inscripcionNueva => {
                  console.log(inscripcionNueva.usuario.inscripciones);
                });
              }
            })
          ).subscribe(
            () => {},
            error => {
              // Maneja el error si ocurre al crear el estado "en curso"
            }
          );
        }
      })
    ).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error.error);
        // Maneja el error si ocurre al verificar el estado "en curso"
      }
    );

  }*/

  async inscribirUsuario(){
    const nombreUsuario = localStorage.getItem('usuario');

    if(nombreUsuario){
      let idUsuario = await lastValueFrom(this.usuarioService.getIdByNombre(nombreUsuario).pipe());
      console.log(idUsuario);

      let idEvento = await lastValueFrom(this.eventoService.getIdByNombre(this.eventoSeleccionado.nombre).pipe());
      console.log(idEvento);

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
      this.router.navigate(['/login']);
    }
  }

  /*async realizarInscripcion(inscripcion: InscripcionModel) {
    console.log("REALIZAR INSCRIPCIÓN");
    console.log(inscripcion);
    return await lastValueFrom(this.inscripcionService.inscribirUsuario(inscripcion));
  }*/

}
