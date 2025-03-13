CREATE TABLE OPT_Armor (
    Armor_ID INT PRIMARY KEY AUTO_INCREMENT,
    Armor_Name VARCHAR(50),
    Armor_Price_Value FLOAT,
    Armor_Price_Unit_REF INT
    REFERENCES OPT_Units (Unit_ID),
    Armor_Weight_Value FLOAT,
    Armor_Weight_Unit_REF INT
    REFERENCES OPT_Units (Unit_ID),
    Armor_Description VARCHAR(300),
    Armor_Category_REF INT
    REFERENCES OPT_ArmorCategory (ArmorCategory_ID),
    Armor_ItemTags_REF INT
    REFERENCES REL_Item_ItemTags (Item_ID_REF),
    Armor_BaseArmorClass TINYINT,
    Armor_StrengthRequirement TINYINT,
    Armor_StealthDisadvantage BOOL
)