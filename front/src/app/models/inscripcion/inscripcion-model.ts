import {UsuarioModel} from "../usuario/usuario-model";
import {EventoModel} from "../evento/evento-model";
import {EstadoModel} from "../estado/estado-model";

export interface InscripcionModel {
  fecha : Date;

  //Relaciones:
  usuario :UsuarioModel;

  evento :EventoModel;

  estado: EstadoModel;
}
