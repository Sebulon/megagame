/**
 * Data class with links to different backend calls
 */
export class Links {
  public static ships = 'api/ships/allShips';
  public static postShip = 'api/ships/allShips';
  public static teams = 'api/teams/all';
  public static getPlayers = 'api/players/all';
  public static addTeam = 'api/teams';

  public static changeShipHP(ship: string, hpChange: number) {
    return `api/ships/${ship}/modify/HP/${hpChange}`;
  }

  public static deleteShip(ship: string) {
    return `api/ships/${ship}/modify/delete`;
  }

  public static playerShip(id: string) {
    return `api/players/${id}/current-ship`;
  }

  public static playerShipResource(ship: string) {
    return `api/ships/playerShip/${ship}/resources`;
  }

  public static sendResources(from: string, to: string) {
    return `api/ships/playerShip/${from}/resources/transfer/${to}`;
  }

  public static getUser(id: string) {
    return `api/users/${id}`;
  }

  public static deleteTeam(teamName: string) {
    return `api/teams/delete/${teamName}`;
  }
}
