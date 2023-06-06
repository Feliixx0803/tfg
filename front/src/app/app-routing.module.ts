import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EventoComponent } from './components/evento/evento.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { AutenticacionComponent } from './components/autenticacion_miro/autenticacion.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CrearEventoComponent } from "./components/evento/crear-evento/crear-evento.component";
import { DetallesEventoComponent } from './components/evento/detalles-evento/detalles-evento.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import {NoPageFoundComponent} from "./errorPage/no-page-found/no-page-found.component";

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'usuario/:nombre', component: UsuarioComponent },
  { path: 'home', component: HomeComponent },
  { path: 'evento', component: EventoComponent },
  { path: 'autenticacion', component: AutenticacionComponent},
  { path: 'calendario', component: CalendarioComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'nuevo-evento', component: CrearEventoComponent},
  { path: 'detalles/:nombre', component: DetallesEventoComponent},
  { path: "error", component:NoPageFoundComponent},
  { path: "**", redirectTo: "error", pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
