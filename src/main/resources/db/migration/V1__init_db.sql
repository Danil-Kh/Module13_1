
USE SpaceTravelDB;

CREATE TABLE Client(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(200),
                       check (CHAR_LENGTH(name) >= 3)
);

CREATE TABLE Planet (
                        id VARCHAR(500) PRIMARY KEY
                            CHECK (id REGEXP '^[A-Z][A-Z0-9]*$'),
                        name VARCHAR(500) NOT NULL
);

CREATE TABLE Ticket (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        client_id INT,
                        from_planet_id VARCHAR(500),
                        to_planet_id VARCHAR(500)
);



