import {UsuarioModel} from "../usuario/usuario-model";
import {EventoModel} from "../evento/evento-model";
import {EstadoModel} from "../estado/estado-model";

export class InscripcionModel {
  id :number;
  fecha : Date;

  //Relaciones:
  usuario :UsuarioModel;

  evento :EventoModel;

  estado :EstadoModel;
}