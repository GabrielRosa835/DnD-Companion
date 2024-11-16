CREATE TABLE OBJ_ItemBaseProperties (
    ItemBaseProperties_Id INT PRIMARY KEY AUTO_INCREMENT,
    ItemBaseProperties_Name VARCHAR(50) UNIQUE NOT NULL,
    ItemBaseProperties_NormalPrice FLOAT NOT NULL,
    ItemBaseProperties_NormalWeight FLOAT NOT NULL,
    ItemBaseProperties_Description TEXT
);

CREATE TABLE REL_ItemBaseProperty_ItemTags (
    ItemBaseProperties_Id_REF INT,
    ItemTag_Id_REF INT,
    PRIMARY KEY (ItemBaseProperties_Id_REF, ItemTag_Id_REF),

    FOREIGN KEY FRK_ItemBaseProperty_ItemTags_ItemBasePropertiesIdREF (ItemBaseProperties_Id_REF)
    REFERENCES OBJ_ItemBaseProperties (ItemBaseProperties_Id),

    FOREIGN KEY FRK_ItemBaseProperty_ItemTags_ItemTagIdREF (ItemTag_Id_REF)
    REFERENCES OPT_ItemTags (ItemTag_Id)
);

CREATE TABLE OPT_ItemTags (
    ItemTag_Id INT PRIMARY KEY AUTO_INCREMENT,
    ItemTag_Name VARCHAR(20) UNIQUE,
);