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

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    PruebaLoginComponent,
    PruebaRegistroComponent,
    RolComponent
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
