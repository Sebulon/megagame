DROP TABLE IF EXISTS user CASCADE;

CREATE TABLE user (
  ID VARCHAR(250) PRIMARY KEY,
  ROLE VARCHAR(250) NOT NULL
);

INSERT INTO user (id, role) VALUES
  ('test', 'controller'),
  ('test2', 'player');

INSERT INTO team VALUES
  ('testTeam1'),
  ('testTeam2');

INSERT INTO player VALUES
  (1, 'testTeam1'),
  (2, 'testTeam1'),
  (3, 'testTeam2'),
  (4, 'testTeam2');

--INSERT INTO player_ship VALUES
--  ('PlayerShip1', 100, 10, 'PlayerFaction1', 100, null, 'testTeam1'),
--  ('PlayerShip2', 200, 8, 'PlayerFaction2', 180, null, 'testTeam2');

