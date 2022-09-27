import { DateNight } from './../models/date-night';
import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'categoryType'
})
export class CategoryTypePipe implements PipeTransform {

  transform(dateNights: DateNight[], name: string): DateNight[] {
    let result: DateNight[] = [];
    for(let dateNight of dateNights){
      for(let category of dateNight.categories){
        if(category.name === name){
          result.push(dateNight);
        }
      }
    }
    return result;
  }

}
