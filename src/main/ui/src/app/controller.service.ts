import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Ship} from "./objects/ship";
import {Links} from "./links";
import {throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import {Player} from "./objects/player";

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  constructor(private http: HttpClient) {
  }

  getShips() {
    return this.http.get<Ship[]>(Links.ships);
  }

  /**
   * Tries to add ship to backend, console logs the error if present.
   * @param newShip The ship data to create a ship with
   */
  addShip(newShip: Ship) {
    return this.http.post(Links.postShip, newShip).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  /**
   * Get all players that the backend knows of.
   */
  getPlayers() {
    return this.http.get<Player[]>(Links.users + '/player');
  }

  /**
   * Gives information about error
   * @param error Error response
   * @private
   */
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(`Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

  /**
   * Changes the hp of a ship in the backend.
   * @param ship The name of the ship to change.
   * @param hpChange The amount to change with.
   */
  changeShipHP(ship: string, hpChange: number) {
    return this.http.put(Links.changeShipHP(ship, hpChange), null).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  /**
   * Sends a request to delete a ship.
   * @param ship The name of the ship to be deleted.
   */
  deleteShip(ship: string) {
    return this.http.delete(Links.deleteShip(ship)).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

}
