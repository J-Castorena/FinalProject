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

  constructor(private CategoryService: CategoryService){}

  ngOnInit(): void {
    this.displayAllCategories();
  }

  displayAllCategories()  {
    this.CategoryService.getAllCategories().subscribe({
      next: (data) => {
        this.categories = data;
      },
      error: (err) => {
        console.error(
          'Home.component.ts displayAllCategories(): error retrieving categories ' + err
        );
      },
    });
  }


}


