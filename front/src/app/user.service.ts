import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/usuario`);
  }

  getUser(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/usuario/find/${id}`);
  }
  addUser(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/usuario/add`);
  }
  updateUser(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/usuario/update`);
  }
}
