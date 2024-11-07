
USE SpaceTravelDB;

CREATE TABLE Client(
                       customer_id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(200),
                       check (CHAR_LENGTH(name) >= 3)
);

CREATE TABLE Planet (
                        id VARCHAR(500) PRIMARY KEY
                            CHECK (id REGEXP '^[A-Z][A-Z0-9]*$'),
                        name VARCHAR(500) NOT NULL
);

CREATE TABLE Ticket (
                        ticket_id INT AUTO_INCREMENT PRIMARY KEY,
                        created_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP,
                        customer_id INT,
                        from_planet_id VARCHAR(500),
                        to_planet_id VARCHAR(500),

                        FOREIGN KEY (customer_id) REFERENCES Client(customer_id),
                        FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);


