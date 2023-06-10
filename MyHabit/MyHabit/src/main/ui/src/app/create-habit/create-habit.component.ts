import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HabitComponent } from '../habit/habit.component';



@Component({
  selector: 'app-create-habit',
  templateUrl: './create-habit.component.html',
  styleUrls: ['./create-habit.component.css']
})
export class CreateHabitComponent implements OnInit {

  model: any = {}

  constructor(habitService:HabitComponent,
    private http: HttpClient,
    private router: Router) { 
    
  }

  ngOnInit(): void {
  }

  onAddHabit(){
    let url = 'http://localhost:8080/createHabit'
    let habitData = {
      habitName: this.model.habitName,
      description: this.model.description,
    };
    console.log(habitData)
    this.http.post<any>(url, habitData).subscribe(res =>{
      console.log(res)
    })
  }

}
