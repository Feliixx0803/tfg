import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent {

  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this.apiUrl+'/usuario/all').subscribe((response) => {
      console.log(response);
    });
  }
}
