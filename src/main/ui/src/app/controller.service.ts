import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Ship} from "./ship";
import {Links} from "./links";
import {throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';

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

}
