CREATE TABLE OBJ_Item_Armors (
    Item_Armor_Id INT PRIMARY KEY AUTO_INCREMENT,
    Item_BasicProperties_REF INT UNIQUE NOT NULL,

    Item_Armor_Category_REF INT NOT NULL,
    Item_Armor_BaseArmorClass SMALLINT NOT NULL,
    Item_Armor_StrengthRequirement SMALLINT NOT NULL,
    Item_Armor_StealthDisavantage BOOLEAN NOT NULL,

    FOREIGN KEY FRK_Item_Armors_Item_BasicProperties_REF (Item_BasicProperties_REF)
    REFERENCES OBJ_Item_BasicProperties (Item_BasicProperties_Id),

    FOREIGN KEY FRK_Item_Armors_Item_Armor_Category_REF (Item_Armor_Category_REF)
    REFERENCES OPT_Armor_Categories (Armor_Category_Id)
)

CREATE TABLE OPT_Armor_Categories (
    Armor_Category_Id INT PRIMARY KEY AUTO_INCREMENT,
    Armor_Category VARCHAR(20) UNIQUE
)