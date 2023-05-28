import { UsuarioModel } from "../usuario/usuario-model";

export class EventoModel {
  id :number;
  nombre :string;
  fechaInicio :Date;
  fechaFin :Date;
  descripcion :string;

  //Relaciones
  usuario :UsuarioModel;
}
