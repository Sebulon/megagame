export interface SolarSystem {
  name: string,
  size: number,
  connections: SolarSystem[],
  visited: boolean,
  celestialObjects: CelestialBody[]
}

export interface CelestialBody {
  name: string,
  type: string,
  features: Feature[],
  size: number
}

export interface Feature {
  name: string,
  description: string
}
