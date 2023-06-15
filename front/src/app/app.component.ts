import { Component, OnInit } from '@angular/core';
import { RolService } from './services/rol/rol.service';
import { lastValueFrom } from 'rxjs';
import { EstadoService } from './services/estado/estado.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'front';

  constructor(private rolService: RolService, private estadoService: EstadoService){}

  ngOnInit(): void {
    
    this.verificarRoles();
    this.verificarEstado();

  }

  async verificarRoles(){
    await lastValueFrom(this.rolService.getAllRoles().pipe()).then((roles) => {
      if(roles.length == 0){
        this.rolService.addRol().subscribe();
      }
    });
  }

  verificarEstado(){
    this.estadoService.verificarEstadoInscrito('Inscrito').subscribe();
  }
}
