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

CREATE TABLE author_books (
  id   INTEGER IDENTITY PRIMARY KEY,
  author_id INTEGER NOT NULL,
  book_id INTEGER NOT NULL
);
-- CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE books (
   id         INTEGER IDENTITY PRIMARY KEY,
  book_name VARCHAR(300),
  isbn VARCHAR(300)
);

CREATE TABLE genres (
   id         INTEGER IDENTITY PRIMARY KEY,
  genre_name VARCHAR(300)
);

create TABLE books_genre (
  id   INTEGER IDENTITY PRIMARY KEY,
  genre_id INTEGER NOT NULL,
  book_id INTEGER NOT NULL
);

--
-- ALTER TABLE author ADD CONSTRAINT fk_author_books FOREIGN KEY (author_id) REFERENCES vets (id);
-- ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);
--
-- CREATE TABLE types (
--   id   INTEGER IDENTITY PRIMARY KEY,
--   name VARCHAR(80)
-- );
-- CREATE INDEX types_name ON types (name);
--
-- CREATE TABLE owners (
--   id         INTEGER IDENTITY PRIMARY KEY,
--   first_name VARCHAR(30),
--   last_name  VARCHAR_IGNORECASE(30),
--   address    VARCHAR(255),
--   city       VARCHAR(80),
--   telephone  VARCHAR(20)
-- );
-- CREATE INDEX owners_last_name ON owners (last_name);
--
-- CREATE TABLE pets (
--   id         INTEGER IDENTITY PRIMARY KEY,
--   name       VARCHAR(30),
--   birth_date DATE,
--   type_id    INTEGER NOT NULL,
--   owner_id   INTEGER NOT NULL
-- );
-- ALTER TABLE pets ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
-- ALTER TABLE pets ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES types (id);
-- CREATE INDEX pets_name ON pets (name);
--
-- CREATE TABLE visits (
--   id          INTEGER IDENTITY PRIMARY KEY,
--   pet_id      INTEGER NOT NULL,
--   visit_date  DATE,
--   description VARCHAR(255)
-- );
-- ALTER TABLE visits ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES pets (id);
-- CREATE INDEX visits_pet_id ON visits (pet_id);
