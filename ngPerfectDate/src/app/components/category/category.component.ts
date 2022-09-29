import { DateNightService } from './../../services/date-night.service';
import { DateNight } from './../../models/date-night';
import { CategoryService } from './../../services/category.service';
import { Category } from './../../models/category';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: Category[] =  [];
  newCategory: Category = new Category;
  displayNewCategoryForm = false;

  dateNights: DateNight[] = [];


  selected: Category | null = null;
  selectedType = 'all';
  categoryChunks: any;

  types = [
  'all',
  'Romantic',
  'Relaxing',
  'First Date',
  'Second Date',
  'Adventure',
  'Wilderness',
  'Extreme',
  'Shows'
  ];

  constructor(private categoryService: CategoryService, private dateNightService: DateNightService){}

  ngOnInit(): void {
    this.displayAllCategories();
    this.getDates();
  }

  displayAllCategories()  {
    this.categoryService.getAllCategories().subscribe({
      next: (data) => {
        this.categories = data;
        this.categoryChunks = this.sliceIntoChunks(this.categories, 4)
        console.log(this.categories);
      },
      error: (err) => {
        console.error(
          'Home.component.ts displayAllCategories(): error retrieving categories ' + err
        );
      },
    });
  }

  getDates(): void {
    this.dateNightService.index().subscribe(
      {
      next: (dateNights) => {
        this.dateNights = dateNights;
      },
      error: (err) => {
        console.log('DatenightComponent.reload(): error loading datenights:');
        console.log(err);
      }
      }
    );
  }

  viewDetails(selectedCategory: Category){
    this.selected = selectedCategory;
  }

   sliceIntoChunks(arr: any, chunkSize: number) {
    const res = [];
    for (let i = 0; i < arr.length; i += chunkSize) {
        const chunk = arr.slice(i, i + chunkSize);
        res.push(chunk);
    }
    return res;
}

floor(num: number){
return Math.floor(num);
}


}


