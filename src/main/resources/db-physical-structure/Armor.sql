CREATE TABLE armor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    price_id INT NOT NULL,
    weight_id INT NOT NULL,
    description TEXT,
    category_id INT,
    base_armor_class TINYINT,
    strength_requirement TINYINT,
    stealth_disadvantage TINYINT(1)
);