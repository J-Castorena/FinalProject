import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';

@Pipe({
  name: 'userType'
})
export class UserTypePipe implements PipeTransform {

  transform(users: User[], username: string): User[] {
    let result: User[] = [];
    for(let user of users){
      for(let blog of user.blogs){
        if(blog.user.username === username){
          result.push(user);
        }
      }
    }
    return result;
  }

}
