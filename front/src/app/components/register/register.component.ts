import { HttpClient } from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { VentanaErrorComponent } from '../ventana-error/ventana-error.component';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{
  miFormulario :FormGroup = new FormGroup({});

  /**
   * Crea una instancia del componente RegisterComponent.
   * @param http - Instancia de HttpClient utilizada para realizar solicitudes HTTP.
   * @param router - Instancia de Router utilizada para la navegación a diferentes rutas.
   * @param dialogRef - Instancia de MatDialog utilizada para abrir un diálogo de error.
   * @param formBuilder - Instancia de FormBuilder utilizada para construir el formulario con validaciones.
   */
  constructor(public http: HttpClient,
              private router: Router,
              private dialogRef: MatDialog,
              private formBuilder: FormBuilder
              ) { }

  /**
   * Se ejecuta al inicializar el componente.
   * Inicializa los campos del formulario y les establece las validaciones.
   */
  ngOnInit(): void {
    //Inicializamos los campos del form y le establecemos las validaciones
    this.miFormulario = this.formBuilder.group({
      //Puede tener mayusculas y/o minusculas, sin espacios. Se permiten acentuados.
      nombre : ['',Validators.compose([Validators.required,Validators.pattern('[A-Za-záéíóúÁÉÍÓÚ\s]+$')])],
      email: ['',Validators.compose([Validators.required,Validators.email])],
      telefono : ['',Validators.compose([Validators.required,Validators.pattern('[0-9]{9}')])],
      //Minimo una mayuscula, minimo 1 minuscula, 8 caracteres minimo
      password: ['',Validators.compose([Validators.required,Validators.pattern('(?=.*[a-z])(?=.*[A-Z]).{8,}')])]
    })
  }


  /**
   * Getter para obtener el campo 'nombre' del formulario.
   * @returns El campo 'nombre' del formulario.
   */
  get nombre(){
    return this.miFormulario.get('nombre');
  }

  /**
   * Getter para obtener el campo 'telefono' del formulario.
   * @returns El campo 'telefono' del formulario.
   */
  get telefono(){
    return this.miFormulario.get('telefono');
  }

  /**
   * Getter para obtener el campo 'email' del formulario.
   * @returns El campo 'email' del formulario.
   */
  get email(){
    return this.miFormulario.get('email');
  }

  /**
   * Getter para obtener el campo 'password' del formulario.
   * @returns El campo 'password' del formulario.
   */
  get password(){
    return this.miFormulario.get('password');
  }

  /**
   * Realiza el registro de un nuevo usuario.
   */
  register(): void{
    let nombre = this.nombre?.value;
    let email = this.email?.value;
    let telefono = this.telefono?.value;
    let pwd = this.password?.value;

    let body = {
      nombre: nombre,
      email: email,
      telefono: telefono,
      pwd: pwd
    }


    this.http.post('http://localhost:8080/register', body, { 'responseType': 'text' }).subscribe(
      (response) => this.router.navigate(["/login"]),
      (error) => //this.open("Ya existe un usuario con ese email")
      console.log("Error al registrar usuario")
    );
  }
}
