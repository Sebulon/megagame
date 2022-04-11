/**
 * Data class with links to different backend calls
 */
export class Links {
  // PLAYERS AND USERS
  public static getPlayers = 'api/players/all';

  public static getUser(id: string) {
    return `api/users/${id}`;
  }

  public static getPlayer(id: string) {
    return `api/players/${id}`;
  }

  // SHIPS
  public static ships = 'api/ships/allShips';
  public static postShip = 'api/ships/playerShips';

  public static changeShipHP(ship: string, hpChange: number) {
    return `api/ships/${ship}/modify/HP/${hpChange}`;
  }

  public static deleteShip(ship: string) {
    return `api/ships/${ship}/modify/delete`;
  }

  public static playerShip(id: string) {
    return `api/players/${id}/current-ship`;
  }

  public static getShip(name: string) {
    return `api/ships/getPlayerShip/name/${name}`;
  }

  public static playerShipResource(ship: string) {
    return `api/ships/playerShip/${ship}/resources`;
  }

  public static sendResources(from: string, to: string) {
    return `api/ships/playerShip/${from}/resources/transfer/${to}`;
  }

  public static changeResources(name: string) {
    return `api/ships/playerShip/${name}/resources/modify`;
  }


  // TEAMS
  public static teams = 'api/teams';
  public static allTeams = this.teams + '/all';
  public static assignPlayer = this.teams + '/assignPlayer';
  public static removePlayer = this.teams + '/removePlayer';

  public static team(teamName: string) {
    return `${this.teams}/get/${teamName}`;
  }

  public static deleteTeam(teamName: string) {
    return `api/teams/delete/${teamName}`;
  }

  static getController(id: string) {
    return `api/controller/${id}`;
  }
}
