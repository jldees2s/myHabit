import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { profile } from './profile'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
//   public profileFound? : profile
  constructor(private http: HttpClient,
    private router: Router) { }

ngOnInit(): void {
    let userId = 101;
    let url = `http://localhost:8080/profile/${userId}`
    this.http.get<any>(url).subscribe(res =>{
      console.log("test")
      console.log(res)
//       if(res.id !== 0){
//          this.router.navigate(["home"])
//       }
  })
}
}
