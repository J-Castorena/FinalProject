import { Component, OnInit } from '@angular/core';
import { DateNight } from 'src/app/models/date-night';
import { Review } from './../../models/review';
import { User } from './../../models/user';
import { AuthService } from './../../services/auth.service';
import { DateNightService } from './../../services/date-night.service';
import { ReviewService } from './../../services/review.service';

@Component({
  selector: 'app-datenight',
  templateUrl: './datenight.component.html',
  styleUrls: ['./datenight.component.css']
})
export class DatenightComponent implements OnInit {

  datenights: DateNight [] = [];
  selected: DateNight | null = null;
  newDateNight: DateNight = new DateNight();
  editDateNight: DateNight | null = null;
  loggedIn: User = new User();
  newReview: Review = new Review();
  showAddReviewForm: boolean = false;








  constructor(private DateNightService: DateNightService, private auth: AuthService, private reviewServ: ReviewService) { }

  ngOnInit(): void {
    this.loadDateNights();
    this.getLoggedInUser();


    console.log(this.datenights);

    // for(let datenight of this.datenights) {
    //   console.log(datenight);

    //  this.loadAverageRating(datenight);

    // }


    console.log(this.datenights);

  }
  getLoggedInUser(){

    return this.auth.getLoggedInUser().subscribe(
      {
        next: (data) => {
        this.loggedIn = data;
        },
        error: (err) => {
          console.log('DatenightComponent.getLoggedInUser(): error loading loggedInUser:');
          console.log(err);
      }
    }
    );
  }

  loadAverageRating(datenight: DateNight){
    let average: number = 0;
    let counter: number = 0;
    if(datenight.reviews) {

      for(let review of datenight.reviews) {
        console.log(review);

        average += review.rating;
        counter++;
      }
    }
    if(counter > 0 && this.selected){
      this.selected.avgRating = average/counter;
      return average/counter;

    }
    return 0;
  }

  loadDateNights(): void {

    this.DateNightService.index().subscribe(

      {
      next: (datenights) => {
        this.datenights = datenights;
        for(let datenight of this.datenights) {
          console.log(this.datenights);

          this.loadReviews(datenight);
          datenight.avgRating = this.loadAverageRating(datenight);
        }
      },
      error: (err) => {
        console.log('DatenightComponent.reload(): error loading datenights:');
        console.log(err);
      }
      }
    );
  }

  loadReviews(datenight: DateNight) {
    this.reviewServ.getReviewsByDateNightId(datenight).subscribe(
      {
        next: (reviews) => {

          datenight.reviews = reviews;
          reviews = datenight.reviews;
          console.log(datenight.reviews);

        },
        error: (err) => {
          console.log(err);

        }
      }
    )
  }

  reload(){
    this.DateNightService.index().subscribe(
      {
        next: (data) => {
          this.datenights = data
        },
        error: (err) => {
          console.log('DatenightComponent.reload(): error loading datenights:');
          console.log(err);
        }
      }
    )
  }



  create(dateNight: DateNight): void {
    this.DateNightService.create(this.newDateNight).subscribe(
      {
        next: (result) => {
          this.newDateNight = new DateNight();
          this.reload();

        },
        error: (problem) => {
          console.error('DateNightHttpComponent.createDateNight(): error adding datenight:');
          console.error(problem);
        }
      }
    );
  }
  userLoggedIn(){
    return this.auth.checkLogin();
  }
  display(datenight: DateNight){
    // datenight.avgRating = this.loadAverageRating(datenight);
    this.selected = datenight;
    console.log(this.selected);
    console.log(this.selected.avgRating);
  }

  setEdit() {
    this.editDateNight = Object.assign({}, this.selected);
  }
  update(updatedDateNight: DateNight) {
  this.DateNightService.update(updatedDateNight).subscribe(
    {
      next: (data) => {
        this.selected = data;
        this.editDateNight = null;
        this.reload();
      },
      error: (err) => {
        console.error('DateNightListComponent.updateDateNight(): error updating datenight:');
        console.error(err);
      }

    }
  )
  }

  updateCompleted(updatedDateNight: DateNight) {
    this.DateNightService.update(updatedDateNight).subscribe(
     {
       next: (data) => {
         this.reload();
       },
       error: (err) => {
         console.error('DateNightListComponent.updateDateNight(): error updating datenight:');
         console.error(err);
       }
     }
   );

   }

  delete(id: number) {
    this.DateNightService.delete(id).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.reload();
        },
        error: (err) => {
          console.error('DateNightComponent.delete(): error deleting datenight:');
          console.error(err);
        }
      }
    )
  }

showReviewForm(){
    this.showAddReviewForm = true;
}

  addReview(review: Review, dateNightId: number) {
    this.reviewServ.create(review, dateNightId).subscribe(
      {
        next: (data) => {
          this.reload();
        },
        error: (err) => {
          console.error('DateNightComponent.addReview(): error adding review:');
          console.error(err);
        }
      }
    );
  }


}
