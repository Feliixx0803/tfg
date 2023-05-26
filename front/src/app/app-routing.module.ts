import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EventosComponent } from './eventos/eventos.component';
import { AutenticacionComponent } from './autenticacion/autenticacion.component';
import { CalendarioComponent } from './calendario/calendario.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'eventos', component: EventosComponent },
  { path: 'autenticacion', component: AutenticacionComponent},
  { path: 'calendario', component: CalendarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
