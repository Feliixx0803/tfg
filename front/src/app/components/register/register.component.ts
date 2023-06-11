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

  constructor(public http: HttpClient,
              private router: Router,
              private dialogRef: MatDialog,
              private formBuilder: FormBuilder
              ) { }

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


  //Getters de los inputs del formulario:
  get nombre(){
    return this.miFormulario.get('nombre');
  }

  get telefono(){
    return this.miFormulario.get('telefono');
  }
  get email(){
    return this.miFormulario.get('email');
  }

  get password(){
    return this.miFormulario.get('password');
  }

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

  /*open(texto: String) {
    this.dialogRef.open(VentanaErrorComponent, {
      height: '250px',
      width: '380px',
      data: {
        texto: texto
      }
    });
  }*/
}
