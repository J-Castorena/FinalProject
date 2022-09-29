import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { ReviewService } from './services/review.service';
import { DateNightService } from './services/date-night.service';
import { DateNightDiscussionBoardService } from './services/date-night-discussion-board.service';
import { CategoryService } from './services/category.service';
import { BlogService } from './services/blog.service';
import { BlogCommentService } from './services/blog-comment.service';
import { AddressService } from './services/address.service';
import { AdditionalImage } from './models/additional-image';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CategoryComponent } from './components/category/category.component';
import { LoginComponent } from './components/login/login.component';
import { DatenightComponent } from './components/datenight/datenight.component';
import { BlogComponent } from './components/blog/blog.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { CategoryTypePipe } from './pipes/category-type.pipe';
import { PipesPipe } from './pipes.pipe';
import { LogoutComponent } from './components/logout/logout.component';
import { DatePipe } from '@angular/common';
import { UserTypePipe } from './pipes/user-type.pipe';
import { FooterComponent } from './components/footer/footer.component';
import { ReviewPipe } from './pipes/review.pipe';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    NotfoundComponent,
    CategoryComponent,
    LoginComponent,
    DatenightComponent,
    BlogComponent,
    UserProfileComponent,
    RegisterComponent,
    CategoryTypePipe,
    PipesPipe,
    LogoutComponent,
    UserTypePipe,
    FooterComponent,
    ReviewPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    AddressService,
    BlogCommentService,
    BlogService,
    CategoryService,
    DateNightDiscussionBoardService,
    DateNightService,
    ReviewService,
    UserService,
    AuthService,
    CategoryTypePipe,
    DatePipe

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
