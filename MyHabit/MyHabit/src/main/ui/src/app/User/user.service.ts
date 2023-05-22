import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) { }

  public getUsers(): Observable<any> {

    return this.http.get<any>(`${this.apiServerUrl}/user/all`)
  }
}
