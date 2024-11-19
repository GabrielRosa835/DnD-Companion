CREATE TABLE OPT_Skills (
   Skill_Id INT PRIMARY KEY AUTO_INCREMENT,
   Skill VARCHAR(20) UNIQUE NOT NULL,
   Skill_AbilityScore_REF INT NOT NULL,

   FOREIGN KEY FRK_MainAbilityScore_REF (Skill_MainAbilityScore_REF) 
   REFERENCES OPT_AbilityScores (AbilityScore_Id)
);

CREATE TABLE OPT_AbilityScores (
   AbilityScore_Id INT PRIMARY KEY AUTO_INCREMENT,
   AbilityScore VARCHAR(20) UNIQUE NOT NULL,
);

CREATE TABLE OPT_SavingThrows (
   SavingThrow_Id INT PRIMARY KEY AUTO_INCREMENT,
   SavingThrow VARCHAR(20) UNIQUE NOT NULL,
   SavingThrow_AbilityScore_REF INT NOT NULL,

   FOREIGN KEY FRK_AbilityScore_REF (SavingThrow_AbilityScore_REF) 
   REFERENCES OPT_AbilityScores (AbilityScore_Id)
);