/**
 * Template for how the ship data is stored
 */
export interface Ship {
  crewSize: number;
  maxHP: number;
  faction: string;
  name: string;
  hp: number;
}

/**
 * A ship template class
 */
export class emptyShip implements Ship {
  crewSize = 0;
  faction = '';
  hp = 0;
  maxHP = 0;
  name = '';
}
