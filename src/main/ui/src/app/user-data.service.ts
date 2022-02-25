import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  private id: string | null = null
  private role: string | null = null

  constructor() {
  }

  getId(): string | null {
    return this.id;
  }

  getRole(): string | null {
    return this.role;
  }

  setId(id: string): void {
    this.id = id;
  }

  setRole(role: string): void {
    this.role = role;
  }
}
