import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EventoComponent } from './components/evento/evento.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { AutenticacionComponent } from './components/autenticacion_miro/autenticacion.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'evento', component: EventoComponent },
  { path: 'autenticacion', component: AutenticacionComponent},
  { path: 'calendario', component: CalendarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
