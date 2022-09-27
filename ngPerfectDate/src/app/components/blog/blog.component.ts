import { BlogService } from './../../services/blog.service';
import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/blog';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {


  blogs: Blog [] = [];
  constructor(private BlogService: BlogService) { }


  ngOnInit(): void {
    // this.loadBlogs();
    console.log(this.blogs);

  }
  // loadBlogs(): void {
  //   this.BlogService.index().subscribe(
  //     {
  //     next: (blogs) => {
  //       this.blogs = blogs;
  //     },
  //     error: (err) => {
  //       console.log('DatenightComponent.reload(): error loading datenights:');
  //       console.log(err);
  //     }
  //     }
  //   );
  // }

  // reload(){
  //   this.DateNightService.index().subscribe(
  //     {
  //       next: (data) => {
  //         this.datenights = data
  //       },
  //       error: (err) => {
  //         console.log('DatenightComponent.reload(): error loading datenights:');
  //         console.log(err);
  //       }
  //     }
  //   )
  // }



  // create(dateight: DateNight): void {
  //   this.DateNightService.create(this.newDateNight).subscribe(
  //     {
  //       next: (result) => {
  //         this.newDateNight = new DateNight();
  //         this.reload();

  //       },
  //       error: (problem) => {
  //         console.error('DateNightHttpComponent.createDateNight(): error adding datenight:');
  //         console.error(problem);
  //       }
  //     }
  //   );
  // }
  // display(datenight: DateNight){
  //   this.selected = datenight;
  //   console.log(this.selected);
  // }

  // setEdit() {
  //   this.editDateNight = Object.assign({}, this.selected);
  // }
  // update(updatedDateNight: DateNight) {
  // this.DateNightService.update(updatedDateNight).subscribe(
  //   {
  //     next: (data) => {
  //       this.selected = data;
  //       this.editDateNight = null;
  //       this.reload();
  //     },
  //     error: (err) => {
  //       console.error('DateNightListComponent.updateDateNight(): error updating datenight:');
  //       console.error(err);
  //     }

  //   }
  // )
  // }

  // updateCompleted(updatedDateNight: DateNight) {
  //   this.DateNightService.update(updatedDateNight).subscribe(
  //    {
  //      next: (data) => {
  //        this.reload();
  //      },
  //      error: (err) => {
  //        console.error('DateNightListComponent.updateDateNight(): error updating datenight:');
  //        console.error(err);
  //      }
  //    }
  //  );

  //  }

  // delete(id: number) {
  //   this.DateNightService.delete(id).subscribe(
  //     {
  //       next: (data) => {
  //         this.selected = null;
  //         this.reload();
  //       },
  //       error: (err) => {
  //         console.error('DateNightComponent.delete(): error deleting datenight:');
  //         console.error(err);
  //       }
  //     }
  //   )
  // }

}
