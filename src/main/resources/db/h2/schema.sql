DROP TABLE author IF EXISTS;
DROP TABLE author_books IF EXISTS;
DROP TABLE books IF EXISTS;
DROP TABLE genres IF EXISTS;
DROP TABLE books_genre IF EXISTS;


CREATE TABLE author (
  id         INTEGER IDENTITY PRIMARY KEY,
  author_name VARCHAR(300)
);
CREATE INDEX name ON author (author_name);


CREATE TABLE book (
   id         INTEGER IDENTITY PRIMARY KEY,
  book_name VARCHAR(300),
  isbn VARCHAR(300),
  author_id INTEGER
);

CREATE TABLE genres (
   id         INTEGER IDENTITY PRIMARY KEY,
  genre_name VARCHAR(300)
);
