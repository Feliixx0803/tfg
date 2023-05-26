import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'usuario-perfil',
  templateUrl: './usuario-perfil.component.html',
  styleUrls: ['./usuario-perfil.component.scss']
})
export class UsuarioPerfilComponent implements OnInit {
  userId: any;
  userData: any;

  constructor(private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit() {
    this.userId = this.route.snapshot.paramMap.get('nombre');
    this.getUserData();
  }

  getUserData() {
    this.userService.getUser(this.userId)
      .subscribe(data => {
        this.userData = data;
      });
  }
}
