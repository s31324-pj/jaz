CREATE DATABASE IF NOT EXISTS movie_service;
USE movie_service;


CREATE TABLE movie (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  genre VARCHAR(50) NOT NULL
);


INSERT INTO movie(name, genre) VALUES
  ('The Matrix','science fiction'),
  ('Inception','science fiction'),
  ('The Godfather','drama');

