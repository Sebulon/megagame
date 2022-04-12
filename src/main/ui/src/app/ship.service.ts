import {Injectable} from '@angular/core';
import {Ship} from "./objects/ship";
import {Links} from "./links";
import {HttpClient} from "@angular/common/http";
import {catchError, retry} from "rxjs/operators";
import {handleError} from "./errorHandler";

/**
 * Class for services about ships.
 */
@Injectable({
  providedIn: 'root'
})
export class ShipService {

  constructor(private http: HttpClient) {
  }

  getShip(name: string) {
    return this.http.get<Ship>(Links.ships.get(name));
  }

  getResources(shipName: string) {
    return this.http.get<Map<string, number>>(Links.ships.getResources(shipName));
  }

  getShips() {
    return this.http.get<Ship[]>(Links.ships.all);
  }

  /**
   * Tries to add ship to backend, console logs the error if present.
   * @param newShip The ship data to create a ship with
   */
  addShip(newShip: Ship) {
    return this.http.post(Links.ships.post, newShip).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  /**
   * Changes the hp of a ship in the backend.
   * @param ship The name of the ship to change.
   * @param hpChange The amount to change with.
   */
  changeShipHP(ship: string, hpChange: number) {
    return this.http.put(Links.ships.changeHP(ship, hpChange), null).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  /**
   * Sends a request to delete a ship.
   * @param ship The name of the ship to be deleted.
   */
  deleteShip(ship: string) {
    return this.http.delete(Links.ships.delete(ship)).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  /**
   * Says to backend to send resources from one ship to another.
   * @param from
   * @param to
   * @param resources
   */
  sendResources(from: string, to: string, resources: Map<string, number>) {
    return this.http.put(Links.ships.sendResources(from, to), this.convertMap(resources)).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  changeResources(ship: string, resources: Map<string, number>) {
    return this.http.put(Links.ships.changeResources(ship), this.convertMap(resources)).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  private convertMap(map: Map<any, any>) {
    const convMap = {} as any;
    map.forEach((value, key) => {
      convMap[key] = value;
    });
    return convMap;
  }
}
