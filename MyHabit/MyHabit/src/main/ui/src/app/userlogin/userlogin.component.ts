import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  
  model: any = {};

  constructor(
    private http: HttpClient,
  ) { }

  ngOnInit(): void {
  }

  login(){
    let url = 'localhost:8080/login'
    this.http.post<any>(url,{
      
    })
  }
}


