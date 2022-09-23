import { ɵExtraLocaleDataIndex } from "@angular/core";

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  username: string;
  password: string;
  imageUrl: string;
  biography: string;
  role: string;
  enabled: boolean;
  dob: string;

  constructor(
  id: number = 0,
  firstName: string = '',
  lastName: string = '',
  email: string = '',
  username: string= '',
  password: string = '',
  imageUrl: string = '',
  biography: string = '',
  role: string = '',
  enabled: boolean = false,
  dob: string = '',
  ){
    this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.username = username;
      this.password = password;
      this.imageUrl = imageUrl;
      this.biography = biography;
      this.role = role;
      this.enabled = enabled;
      this.dob = dob;
  }

}
