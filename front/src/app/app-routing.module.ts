import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EventoComponent } from './components/evento/evento.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { AutenticacionComponent } from './components/autenticacion_miro/autenticacion.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'evento', component: EventoComponent },
  { path: 'autenticacion', component: AutenticacionComponent},
  { path: 'calendario', component: CalendarioComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
