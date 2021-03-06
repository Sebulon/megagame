/**
 * Data class with links to different backend calls
 */
export class Links {
  static players = class {
    public static all = 'api/players/all';
    public static create = 'api/players/add'

    public static get(id: string) {
      return `api/players/${id}`;
    }

    public static ship(playerId: string) {
      return `api/ships/getPlayerShip/player/${playerId}`;
    }

    public static delete(playerId: string) {
      return `api/players/delete/${playerId}`;
    }

    public static setRole(id: string) {
      return `api/players/${id}/setRole`
    }
  }

  static ships = class {

    public static all = 'api/ships/allShips';

    /**
     * For creating ships
     */
    public static post = 'api/ships/playerShips';

    public static changeHP(ship: string, hpChange: number) {
      return `api/ships/${ship}/modify/HP/${hpChange}`;
    }

    public static delete(ship: string) {
      return `api/ships/${ship}/modify/delete`;
    }


    public static get(name: string) {
      return `api/ships/getPlayerShip/name/${name}`;
    }

    public static getResources(ship: string) {
      return `api/ships/playerShip/${ship}/resources`;
    }

    public static sendResources(from: string, to: string) {
      return `api/ships/playerShip/${from}/resources/transfer/${to}`;
    }

    public static changeResources(name: string) {
      return `api/ships/playerShip/${name}/resources/modify`;
    }
  }

  static teams = class {
    /**
     * For creating a team
     */
    public static post = 'api/teams';
    public static all = 'api/teams/all';

    public static delete(teamName: string) {
      return `api/teams/${teamName}/delete`
    }

    public static change(teamName: string) {
      return `api/teams/${teamName}/change`;
    }

    public static get(teamName: string) {
      return `api/teams/get/${teamName}`;
    }
  }

  static roles = class {
    public static all = 'api/roles/all'

    public static get(role: string) {
      return `api/roles/${role}`;
    }
  }

  static space = class {
    public static currentSolarSystem = 'api/solar-systems/current'
  }


  static getController(id: string) {
    return `api/controller/${id}`;
  }
}
