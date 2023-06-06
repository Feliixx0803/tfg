import { UsuarioModel } from "../usuario/usuario-model";

export class EventoModel {

  nombre :string;
  fechaInicio :Date;
  fechaFin :Date;
  descripcion :string;
  imagen : File;

  //Relaciones
  gestor :UsuarioModel;
}
