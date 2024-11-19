CREATE TABLE OBJ_MiscellaneousItems (
    MiscellaneousItem_Id INT PRIMARY KEY AUTO_INCREMENT,
    MiscellaneousItem_BaseProperties_REF INT UNIQUE NOT NULL,

    FOREIGN KEY FRK_MiscellaneousItems_BasePropertiesREF (MiscellaneousItem_BaseProperties_REF)
    REFERENCES OBJ_ItemBaseProperties (ItemBaseProperties_Id)
);