CREATE TABLE OBJ_Subclasses (
   Subclass_Id INT PRIMARY KEY AUTO_INCREMENT,
   Subclass_Name VARCHAR(50) UNIQUE NOT NULL,
)

CREATE TABLE REL_Subclasses_Features (
   Subclass_Id_REF INT,
   Feature_Id_REF INT,
   PRIMARY KEY (Subclass_Id_REF, Feature_Id_REF),

   FOREIGN KEY FRK_Subclasses_Features_Subclass_Id_REF (Subclass_Id_REF)
   REFERENCES OBJ_Subclasses (Subclass_Id),

   FOREIGN KEY FRK_Subclasses_Features_Feature_Id_REF (Feature_Id_REF)
   REFERENCES OBJ_Features (Feature_Id_REF)
)
