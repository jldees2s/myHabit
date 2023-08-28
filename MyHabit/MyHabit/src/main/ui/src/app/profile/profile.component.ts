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
  public userProfile!: profile

  constructor(private http: HttpClient,
              private router: Router) {
  }

  ngOnInit(): void {
    if (!localStorage.authToken) {
      this.router.navigate(['/registration'])
    } else {
      let url = `http://localhost:8080/profile/${localStorage.authToken}`
      this.http.get<any>(url).subscribe(res => {
        this.userProfile = res;
      })
    }
  }}

// //Query Selectors
//   const
//   habits = document.querySelectorAll('.habit');
//   const
//   themeBtn = document.querySelector('#modal')
//
// //functions
//   const
//   storage = {}
//
//   const
//   ui = {
//     theme() {
//       // themeBtn.classList.toggle('dark');
//       // const root = document.querySelector(':root');
//       // root.classList.toggle('dark');
//     }
//   }
// }
// function addHabit(){
//   let container: HTMLCollectionOf<Element> = document.getElementsByClassName(".modal-container");
//
//   }
