CREATE TABLE tbl_creature_status ( -- Status = Plural of Ability Scores
   Creature_Id_REF INT,
   Creature_Ability_Score_Option_REF INT,
   Creature_Ability_Score_Value TINYINT,
   FOREIGN KEY fk_creature_id_ref (Creature_Id_REF) 
   REFERENCES tbl_creatures (Creature_Id),
   FOREIGN KEY fk_ability_score_option_ref (Creature_Ability_Score_Option_REF) 
   REFERENCES tbl_ability_score_options (Ability_Score_Option_Id)
);

CREATE TABLE tbl_creature_saving_throws (
   Creature_Id_REF INT,
   Creature_Saving_Throw_Option_REF INT,
   Creature_Saving_Throw_Proficiency BOOLEAN,
   FOREIGN KEY fk_creature_id_ref (Creature_Id_REF) 
   REFERENCES tbl_creatures (Creature_Id),
   FOREIGN KEY fk_saving_throw_option_ref (Creature_Saving_Throw_Option_REF) 
   REFERENCES tbl_saving_throw_options (Ability_Saving_Throw_Id)
);

CREATE TABLE tbl_creature_skills (
   Creature_Id_REF INT,
   Creature_Skill_Option_REF INT,
   Creature_Skill_Proficiency BOOLEAN,
   FOREIGN KEY fk_creature_id_ref (Creature_Id_REF) 
   REFERENCES tbl_creatures (Creature_Id),
   FOREIGN KEY fk_skill_option_ref (Creature_Skill_Option_REF) 
   REFERENCES tbl_skill_options (Skill_Option_Id)
);