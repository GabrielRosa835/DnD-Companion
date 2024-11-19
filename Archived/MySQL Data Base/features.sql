CREATE TABLE tbl_features {
   Feature_Id INT PRIMARY KEY AUTO_INCREMENT,
   Feature_Description TEXT,
   Feature_Effect_REF INT,
   FOREIGN KEY fk_effect_option_ref (Feature_Option_Effect_REF) 
   REFERENCES tbl_effect_options (Effect_Option_Id)
}