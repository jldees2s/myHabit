import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
// import { FlexLayoutModule } from "@angular/flex-layout";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { HttpClientModule, HttpClient} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TimelineComponent } from './timeline/timeline.component';
import { NavbarComponent } from './navbar/navbar.component';

import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';
import { HomepageComponent } from './homepage/homepage.component';


const routes: Routes = [
  {path:"", component: HomepageComponent},
  {path:" ", component: HomepageComponent},
  {path:"login", component: UserloginComponent},
  {path:"profile", component: ProfileComponent},
  { path: "registration", component: RegistrationComponent },
  {path: "timeline", component: TimelineComponent},
  {path:"registration", component: RegistrationComponent},
  {path:"homepage", component: HomepageComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    NavbarComponent,
    TimelineComponent,
    RegistrationComponent,
    HomepageComponent
  ],
  imports: [
    // FlexLayoutModule,
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

