import {RolModel} from "../rol/rol-model";
export class UsuarioModel {

    id :number;
    nombre :string;
    email :string;
    telefono :number;
    password :string;

    //Relacion con rol:
    rol: RolModel

}
