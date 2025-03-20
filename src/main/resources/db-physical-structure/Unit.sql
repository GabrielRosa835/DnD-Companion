CREATE TABLE Unit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    singular_form VARCHAR(30) NOT NULL,
    abbreviation VARCHAR(5) NOT NULL,
    normalizing_factor FLOAT NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY fk_type_id (type_id) REFERENCES UnitType (id)
);