import { DateNightService } from './../../services/date-night.service';
import { DateNight } from './../../models/date-night';
import { Component, OnInit } from '@angular/core';

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

  constructor(private DateNightService: DateNightService) { }

  ngOnInit(): void {
    this.loadDateNights();
    console.log(this.datenights);

  }
  loadDateNights(): void {
    this.DateNightService.index().subscribe(
      {
      next: (datenights) => {
        this.datenights = datenights;
      },
      error: (err) => {
        console.log('DatenightComponent.reload(): error loading datenights:');
        console.log(err);
      }
      }
    );
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



  create(dateight: DateNight): void {
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
  display(datenight: DateNight){
    this.selected = datenight;
    console.log(this.selected);
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
}
