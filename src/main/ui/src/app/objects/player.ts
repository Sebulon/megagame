/**
 * Interface representing the data of a player
 */
import {Ship} from "./ship";

export interface Player {
  id: string,
  boardedShip: Ship
}
