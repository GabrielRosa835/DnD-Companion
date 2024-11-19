CREATE TABLE tbl_spells (
   Spell_Id INT PRIMARY KEY AUTO_INCREMENT,

   Spell_Level TINYINT,
   Spell_VerbalComponent BOOLEAN,
   Spell_SomaticComponent BOOLEAN,
   Spell_MaterialComponent VARCHAR(100),

   Spell_MagicSchool_REF INT,
   Spell_CastingTime_REF INT,
   Spell_Duration_REF INT,

   Spell_Range_REF INT,
   Spell_Range_Value FLOAT,

   Spell_AreaOfEffect_REF INT,
   Spell_AreaOfEffect_Size FLOAT,
);

CREATE TABLE tbl_spells_classes_availability (
   Class_Id_REF INT,
   Spell_Id_REF INT,
   PRIMARY KEY (Class_Id_REF, Spell_Id_REF),
   FOREIGN KEY fk_class_id_ref (Class_Id_REF)
   REFERENCES tbl_classes (Class_Id),
   FOREIGN KEY fk_spell_id_ref (Spell_Id_REF)
   REFERENCES tbl_spells (Spell_Id)
);
