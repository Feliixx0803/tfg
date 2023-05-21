import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './Components/usuario/usuario.component';

import { HttpClientModule } from '@angular/common/http';
import { PruebaLoginComponent } from './prueba-login/prueba-login.component';
import { FormsModule } from '@angular/forms';
import { PruebaRegistroComponent } from './prueba-registro/prueba-registro.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    PruebaLoginComponent,
    PruebaRegistroComponent
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
