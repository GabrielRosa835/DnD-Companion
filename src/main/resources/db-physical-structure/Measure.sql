CREATE TABLE Measure (
	id INT PRIMARY KEY AUTO_INCREMENT,
    unit_id INT NOT NULL,
    value FLOAT NOT NULL,
	FOREIGN KEY fk_unit_id (unit_id) REFERENCES Unit (id)
);

CREATE TABLE Unit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    singular_form VARCHAR(30) NOT NULL,
    abbreviation VARCHAR(5) NOT NULL,
    normalizing_factor FLOAT NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY fk_type_id (type_id) REFERENCES UnitType (id)
);

CREATE TABLE UnitType (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);