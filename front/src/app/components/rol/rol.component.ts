import {Component, OnInit} from '@angular/core';
import {RolModel} from "../../models/rol/rol-model";
import {RolService} from "../../services/rol/rol.service";

@Component({
  selector: 'rol',
  templateUrl: './rol.component.html',
  styleUrls: ['./rol.component.scss']
})
export class RolComponent  implements OnInit{
  roles : RolModel[];

  constructor(private rolService : RolService) { }

  ngOnInit(): void {
    this.getAllRoles();
  }

  private getAllRoles(){
    this.rolService.getAllRoles().subscribe(rol =>{
      this.roles = rol;
    })
  }

}
