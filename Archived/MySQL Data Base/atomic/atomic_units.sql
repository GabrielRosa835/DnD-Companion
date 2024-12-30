CREATE TABLE OPT_DistanceTypes (
   DistanceType_Id INT PRIMARY KEY AUTO_INCREMENT,
   DistanceType_Unit VARCHAR(20) UNIQUE NOT NULL,
   DistanceType_NormalFactor FLOAT NOT NULL
)

CREATE TABLE OPT_WeightTypes (
   WeightType_Id INT PRIMARY KEY AUTO_INCREMENT,
   WeightType_Unit VARCHAR(20) UNIQUE NOT NULL,
   WeightType_NormalFactor FLOAT NOT NULL
)

CREATE TABLE OPT_CurrencyTypes (
   CurrencyType_Id INT PRIMARY KEY AUTO_INCREMENT,
   CurrencyType_Name VARCHAR(20) UNIQUE NOT NULL,
   CurrencyType_NormalFactor FLOAT NOT NULL
)