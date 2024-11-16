CREATE TABLE OBJ_Weapons (
    Weapon_Id INT PRIMARY KEY AUTO_INCREMENT,
    Weapon_BaseProperties_REF INT UNIQUE NOT NULL,

    Weapon_Category ENUM('SIMPLE','MARTIAL') NOT NULL,
    Weapon_Type ENUM('MELEE','RANGED') NOT NULL,
    Weapon_Mastery_REF INT NOT NULL,

    Weapon_Property_MaxRangeType_REF INT CALCULATED,
    Weapon_Property_MaxRange_Value FLOAT DEFAULT NULL,

    Weapon_Property_MinRangeType_REF INT DEFAULT NULL,
    Weapon_Property_MinRange_Value FLOAT DEFAULT NULL,

    Weapon_Property_VersatileDice_REF INT DEFAULT NULL,

    FOREIGN KEY FRK_Weapons_WeaponBasePropertiesREF (Weapon_BaseProperties_REF)
    REFERENCES OBJ_ItemBaseProperties (ItemBaseProperties_Id),
)

CREATE TABLE REL_Weapon_WeaponDamages (
    Weapon_Id_REF INT,
    WeaponDamage_Type_Id_REF INT,
    WeaponDamage_DiceType_Id_REF INT,
    WeaponDamage_Dice_Amount SMALLINT,
    PRIMARY KEY (Weapon_Id_REF),

    FOREIGN KEY FRK_Weapon_WeaponDamages_WeaponIdREF (Weapon_Id_REF)
    REFERENCES OBJ_Weapons (Weapon_Id)
)

CREATE TABLE REL_Weapon_WeaponProperties (
    Weapon_Id_REF INT,
    WeaponProperty_Id_REF INT,
    PRIMARY KEY (Weapon_Id_REF, WeaponProperty_Id_REF),

    FOREIGN KEY FRK_Weapon_WeaponProperties_WeaponIdREF (Weapon_Id_REF)
    REFERENCES OBJ_Weapons (Weapon_Id),

    FOREIGN KEY FRK_Weapon_WeaponProperties_WeaponPropertyIdREF (WeaponProperty_Id_REF)
    REFERENCES OPT_WeaponProperties (WeaponProperty_Id)
)

CREATE TABLE OPT_WeaponProperties (
    WeaponProperty_Id INT PRIMARY KEY AUTO_INCREMENT,
    WeaponProperty_Name VARCHAR(20) UNIQUE NOT NULL
)

CREATE TABLE OPT_WeaponMasteries (
    WeaponMastery_Id INT PRIMARY KEY AUTO_INCREMENT,
    WeaponMastery_Name VARCHAR(20) UNIQUE NOT NULL,
    WeaponMastery_Description TEXT NOT NULL
)