/**
 * Data class with links to different backend calls
 */
export class Links {
  public static ships = 'api/ships/allShips';
  public static postShip = 'api/ships/allShips';
  public static users = 'api/users';

  public static changeShipHP(ship: string, hpChange: number) {
    return `api/ships/${ship}/modify/HP/${hpChange}`;
  }

  public static deleteShip(ship: string) {
    return `api/ships/${ship}/modify/delete`;
  }

  public static playerShip(id: string) {
    return `api/players/${id}/current-ship`;
  }
}
