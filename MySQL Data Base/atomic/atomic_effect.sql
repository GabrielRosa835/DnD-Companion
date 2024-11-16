CREATE TABLE OPT_AreaOfEffectTypes (
   AreaOfEffectType_Id INT PRIMARY KEY AUTO_INCREMENT,
   AreaOfEffectType VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE OPT_EffectDurationTime (
   EffectDurationTime_Id INT PRIMARY KEY AUTO_INCREMENT,
   EffectDurationTime VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE OPT_EffectExecutionTime (
   EffectExecutionTime_Id INT PRIMARY KEY AUTO_INCREMENT,
   EffectExecutionTime VARCHAR(30) UNIQUE NOT NULL
);