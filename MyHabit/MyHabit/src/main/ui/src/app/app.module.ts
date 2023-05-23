import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { HttpClientModule, HttpClient} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TimelineComponent } from './timeline/timeline.component';
import { NavbarComponent } from './navbar/navbar.component';

const routes: Routes = [
  {path:"login", component: UserloginComponent}]


@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    NavbarComponent,
    TimelineComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}

