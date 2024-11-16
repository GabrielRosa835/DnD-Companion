CREATE TABLE OBJ_Classes (
   Class_Id INT PRIMARY KEY AUTO_INCREMENT,
   Class_Name VARCHAR(30) UNIQUE NOT NULL,
   
   Class_HitPointDice_REF INT NOT NULL,
   
   Class_SkillProficiencies_Amount INT NOT NULL,
   Class_SavingThrowProficiencies_Amount INT DEFAULT(2),
   Class_ToolProficiencies_Amount INT DEFAULT(0),
);

CREATE TABLE REL_Class_Subclasses (
   Class_Id_REF INT,
   Subclass_Id_REF INT,
   PRIMARY KEY (Class_Id_REF, Subclass_Id_REF),

   FOREIGN KEY FRK_Class_Subclasses_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_Subclasses_Subclass_Id_REF (Subclass_Id_REF) 
   REFERENCES OBJ_Subclasses (Subclass_Id)
);

CREATE TABLE REL_Class_MainAbilityScores (
   Class_Id_REF INT,
   AbilityScore_Id_REF INT,
   PRIMARY KEY (Class_Id_REF, AbilityScore_Id_REF),

   FOREIGN KEY FRK_Class_MainAbilityScores_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_MainAbilityScores_AbilityScore_Id_REF (AbilityScore_Id_REF) 
   REFERENCES OBJ_AbilityScore_Options (AbilityScoreOption_Id)
);

CREATE TABLE REL_Class_StartingEquipmentOptions (
   Class_Id_REF INT,
   Class_StartingEquipmentOption_Id_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_StartingEquipmentOption_REF),

   FOREIGN KEY FRK_Class_StartingEquipmentOptions_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_StartingEquipmentOptions_StartingEquipmentOption_REF (Class_StartingEquipmentOption_REF) 
   REFERENCES OBJ_StartingEquipment_Options (StartingEquipmentOption_Id)
);

CREATE TABLE REL_Class_ArmorProficiencyOptions (
   Class_Id_REF INT,
   Class_ArmorOption_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_ArmorOption_REF),

   FOREIGN KEY FRK_Class_ArmorProficiencyOptions_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_ArmorProficiencyOptions_ArmorOption_REF (Class_ArmorOption_REF) 
   REFERENCES tbl_armor_options (ArmorOption_Id)
);

CREATE TABLE REL_Class_ToolProficiencyOptions (
   Class_Id_REF INT,
   Class_ToolOption_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_ToolOption_REF),

   FOREIGN KEY FRK_Class_ToolProficiencyOptions_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_ToolProficiencyOptions_ToolOption_REF (Class_ToolOption_REF) 
   REFERENCES tbl_tool_options (ToolOption_Id)
);

CREATE TABLE REL_Class_SavingThrowProficiencyOptions (
   Class_Id_REF INT,
   Class_SavingThrowOption_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_SavingThrowOption_REF),

   FOREIGN KEY FRK_Class_SavingThrowProficiencyOptions_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_SavingThrowProficiencyOptions_SavingThrowOption_REF (Class_SavingThrowOption_REF) 
   REFERENCES tbl_saving_throw_options (SavingThrowOption_Id)
);

CREATE TABLE REL_Class_SkillProficiencyOptions (
   Class_Id_REF INT,
   Class_SkillOption_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_SkillOption_REF),

   FOREIGN KEY FRK_Class_SkillProficiencyOptions_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_Class_SkillProficiencyOptions_SkillOption_REF (Class_SkillOption_REF) 
   REFERENCES OPT_Skills (SkillOption_Id)
);

CREATE TABLE REL_Class_Features (
   Class_Id_REF INT,
   Class_FeatureOption_REF INT,
   PRIMARY KEY (Class_Id_REF, Class_FeatureOption_REF),

   FOREIGN KEY FRK_Class_Id_REF (Class_Id_REF) 
   REFERENCES OBJ_Classes (Class_Id),

   FOREIGN KEY FRK_feature_option_REF (Class_FeatureOption_REF) 
   REFERENCES tbl_feature_options (FeatureOption_Id)
);
