import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './usuario/usuario.component';

import {HttpClientModule} from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { EventosComponent } from './eventos/eventos.component';
import { CalendarioComponent } from './calendario/calendario.component';
import { AutenticacionComponent } from './autenticacion/autenticacion.component';
import { FooterComponent } from './footer/footer.component';
import { EventoCrearComponent } from './evento-crear/evento-crear.component';
import { EventoRegistroComponent } from './evento-registro/evento-registro.component';
import { EventoDetalleComponent } from './evento-detalle/evento-detalle.component';
import { UsuarioPerfilComponent } from './usuario-perfil/usuario-perfil.component';
import { UsuarioRegistroComponent } from './usuario-registro/usuario-registro.component';
import { IncioSesionComponent } from './incio-sesion/incio-sesion.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    NavbarComponent,
    HomeComponent,
    EventosComponent,
    CalendarioComponent,
    AutenticacionComponent,
    FooterComponent,
    EventoCrearComponent,
    EventoRegistroComponent,
    EventoDetalleComponent,
    UsuarioPerfilComponent,
    UsuarioRegistroComponent,
    IncioSesionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
