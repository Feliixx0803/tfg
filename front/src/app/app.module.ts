import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';

import { HttpClientModule } from '@angular/common/http';
<<<<<<< HEAD






=======
>>>>>>> 62bc6edc974015db1f14178904abc428f36b67e7
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RolComponent } from './components/rol/rol.component';
import { InscripcionComponent } from './components/inscripcion/inscripcion.component';
import { EventoComponent } from './components/evento/evento.component';
import { EstadoComponent } from './components/estado/estado/estado.component';
import { FooterComponent } from './components/footer/footer.component';
<<<<<<< HEAD

=======





>>>>>>> 62bc6edc974015db1f14178904abc428f36b67e7
import { HomeComponent } from './components/home/home.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { AutenticacionComponent } from './components/autenticacion_miro/autenticacion.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './ui-controls/navbar/navbar.component';
import { RegisterComponent } from './components/register/register.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { VentanaErrorComponent } from './components/ventana-error/ventana-error.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { EventosDiaComponent } from './components/eventos-dia-dispensable/eventos-dia.component';


@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
<<<<<<< HEAD
=======





    PruebaRegistroComponent,
>>>>>>> 62bc6edc974015db1f14178904abc428f36b67e7





    RolComponent,
    InscripcionComponent,
    EventoComponent,
    EstadoComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    CalendarioComponent,
    AutenticacionComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    VentanaErrorComponent,
    EventosDiaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatDialogModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
