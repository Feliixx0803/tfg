import { EventoModel } from "../evento/evento-model";
import { InscripcionModel } from "../inscripcion/inscripcion-model";
import { RolModel } from "../rol/rol-model";

export interface UsuarioModel {

    nombre :string;
    email :string;
    telefono :string;
    pwd :string;

    //Relaciones:
    rol: RolModel;

    inscripciones: InscripcionModel[];

    eventosGestionados: EventoModel[];
}
