DROP TABLE IF EXISTS user CASCADE;

CREATE TABLE user (
  ID VARCHAR(250) PRIMARY KEY,
  ROLE VARCHAR(250) NOT NULL
);

INSERT INTO user (id, role) VALUES
  ('test', 'controller'),
  ('test2', 'player');