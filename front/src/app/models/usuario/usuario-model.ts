import {RolModel} from "../rol/rol-model";

export class UsuarioModel {

    nombre :string;
    email :string;
    telefono :string;
    pwd :string;

    //Relaciones:
    rol: RolModel
}
