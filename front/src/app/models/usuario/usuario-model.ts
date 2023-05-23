import {RolModel} from "../rol/rol-model";
import {InscripcionModel} from "../inscripcion/inscripcion-model";
export class UsuarioModel {

    id :number;
    nombre :string;
    email :string;
    telefono :number;
    password :string;

    //Relaciones:
    rol: RolModel
}
