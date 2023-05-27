import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';

import { HttpClientModule } from '@angular/common/http';
import { PruebaLoginComponent } from './prueba-login/prueba-login.component';
import { FormsModule } from '@angular/forms';
import { PruebaRegistroComponent } from './prueba-registro/prueba-registro.component';
import { RolComponent } from './components/rol/rol.component';
import { InscripcionComponent } from './components/inscripcion/inscripcion.component';
import { EventoComponent } from './components/evento/evento.component';
import { EstadoComponent } from './components/estado/estado/estado.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar_miro/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { AutenticacionComponent } from './components/autenticacion_miro/autenticacion.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    PruebaLoginComponent,
    PruebaRegistroComponent,
    RolComponent,
    InscripcionComponent,
    EventoComponent,
    EstadoComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    CalendarioComponent,
    AutenticacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
