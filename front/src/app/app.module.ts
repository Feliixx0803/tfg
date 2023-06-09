import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RolComponent } from './components/rol/rol.component';
import { InscripcionComponent } from './components/inscripcion/inscripcion.component';
import { EventoComponent } from './components/evento/evento.component';
import { EstadoComponent } from './components/estado/estado/estado.component';
import { FooterComponent } from './ui-controls/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './ui-controls/navbar/navbar.component';
import { RegisterComponent } from './components/register/register.component';
import { VentanaErrorComponent } from './components/ventana-error/ventana-error.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { CrearEventoComponent } from './components/evento/crear-evento/crear-evento.component';
import { DetallesEventoComponent } from './components/evento/detalles-evento/detalles-evento.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { MatMomentDateModule } from "@angular/material-moment-adapter";
import { NoPageFoundComponent } from './errorPage/no-page-found/no-page-found.component';
import {PopUpComponent} from "./components/popUp/pop-up/pop-up.component";

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    RolComponent,
    InscripcionComponent,
    EventoComponent,
    EstadoComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    CalendarioComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    VentanaErrorComponent,
    CrearEventoComponent,
    DetallesEventoComponent,
    NoPageFoundComponent,
    PopUpComponent
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
    MatDatepickerModule,
    MatMomentDateModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
  ],
  providers: [
    MatDatepickerModule,
    MatMomentDateModule,
    {provide: MAT_DATE_LOCALE, useValue: 'es'},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
