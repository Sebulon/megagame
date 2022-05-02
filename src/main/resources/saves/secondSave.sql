;             
CREATE USER IF NOT EXISTS "SA" SALT '3be1701d2f4eec1d' HASH 'ffcc675c045d80f323c989e2233f3bd6b5dcd1b2affb43165a2a25a6274c2ef6' ADMIN;         
CREATE SEQUENCE "PUBLIC"."HIBERNATE_SEQUENCE" START WITH 1;   
CREATE CACHED TABLE "PUBLIC"."CELESTIAL_BODY"(
    "DTYPE" VARCHAR(31) NOT NULL,
    "NAME" VARCHAR(255) NOT NULL,
    "SIZE" INTEGER NOT NULL,
    "TYPE" VARCHAR(255),
    "SATELLITE_WEIGHT" INTEGER
);              
ALTER TABLE "PUBLIC"."CELESTIAL_BODY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("NAME");             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CELESTIAL_BODY;          
CREATE CACHED TABLE "PUBLIC"."CELESTIAL_BODY_FEATURES"(
    "CELESTIAL_BODY_NAME" VARCHAR(255) NOT NULL,
    "FEATURES_NAME" VARCHAR(255) NOT NULL
);      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CELESTIAL_BODY_FEATURES; 
CREATE CACHED TABLE "PUBLIC"."CELESTIAL_BODY_SATELLITES"(
    "PLANETOID_NAME" VARCHAR(255) NOT NULL,
    "SATELLITES_NAME" VARCHAR(255) NOT NULL
);       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CELESTIAL_BODY_SATELLITES;               
CREATE CACHED TABLE "PUBLIC"."FEATURE"(
    "NAME" VARCHAR(255) NOT NULL,
    "DESCRIPTION" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."FEATURE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("NAME");    
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.FEATURE; 
CREATE CACHED TABLE "PUBLIC"."GALAXY"(
    "NAME" VARCHAR(255) NOT NULL
);  
ALTER TABLE "PUBLIC"."GALAXY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("NAME");     
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GALAXY;  
CREATE CACHED TABLE "PUBLIC"."GALAXY_SOLAR_SYSTEMS"(
    "GALAXY_NAME" VARCHAR(255) NOT NULL,
    "SOLAR_SYSTEMS_NAME" VARCHAR(255) NOT NULL
);            
ALTER TABLE "PUBLIC"."GALAXY_SOLAR_SYSTEMS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("GALAXY_NAME", "SOLAR_SYSTEMS_NAME");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GALAXY_SOLAR_SYSTEMS;    
CREATE CACHED TABLE "PUBLIC"."GATHER_MINIGAME"(
    "SHIP" VARCHAR(255) NOT NULL,
    "SOURCE_PLANET_NAME" VARCHAR(255)
); 
ALTER TABLE "PUBLIC"."GATHER_MINIGAME" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F6" PRIMARY KEY("SHIP");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GATHER_MINIGAME;         
CREATE CACHED TABLE "PUBLIC"."GATHER_MINIGAME_ALLOCATED_CREW"(
    "GATHER_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "ALLOCATED_CREW" INTEGER,
    "ALLOCATED_CREW_KEY" VARCHAR(255) NOT NULL
);          
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_ALLOCATED_CREW" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("GATHER_MINIGAME_SHIP", "ALLOCATED_CREW_KEY");       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GATHER_MINIGAME_ALLOCATED_CREW;          
CREATE CACHED TABLE "PUBLIC"."GATHER_MINIGAME_BASE_EXTRACTION_RATE"(
    "GATHER_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "BASE_EXTRACTION_RATE" INTEGER,
    "BASE_EXTRACTION_RATE_KEY" VARCHAR(255) NOT NULL
);        
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_BASE_EXTRACTION_RATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("GATHER_MINIGAME_SHIP", "BASE_EXTRACTION_RATE_KEY");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GATHER_MINIGAME_BASE_EXTRACTION_RATE;    
CREATE CACHED TABLE "PUBLIC"."GATHER_MINIGAME_MINIMUM_CREW"(
    "GATHER_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "MINIMUM_CREW" INTEGER,
    "MINIMUM_CREW_KEY" VARCHAR(255) NOT NULL
);
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_MINIMUM_CREW" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("GATHER_MINIGAME_SHIP", "MINIMUM_CREW_KEY");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.GATHER_MINIGAME_MINIMUM_CREW;            
CREATE CACHED TABLE "PUBLIC"."MAIN_GAME"(
    "SESSION_NAME" VARCHAR(255) NOT NULL,
    "TURN" INTEGER NOT NULL,
    "CURRENT_SYSTEM_NAME" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."MAIN_GAME" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("SESSION_NAME");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MAIN_GAME;               
CREATE CACHED TABLE "PUBLIC"."MORALE_MINIGAME"(
    "SHIP" VARCHAR(255) NOT NULL,
    "MORALE_SCORE" INTEGER NOT NULL
);   
ALTER TABLE "PUBLIC"."MORALE_MINIGAME" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_33" PRIMARY KEY("SHIP");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MORALE_MINIGAME;         
CREATE CACHED TABLE "PUBLIC"."MORALE_MINIGAME_ALLOCATED_RESOURCES"(
    "MORALE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "ALLOCATED_RESOURCES" INTEGER,
    "ALLOCATED_RESOURCES_KEY" VARCHAR(255) NOT NULL
);           
ALTER TABLE "PUBLIC"."MORALE_MINIGAME_ALLOCATED_RESOURCES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("MORALE_MINIGAME_SHIP", "ALLOCATED_RESOURCES_KEY");             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MORALE_MINIGAME_ALLOCATED_RESOURCES;     
CREATE CACHED TABLE "PUBLIC"."MORALE_MINIGAME_QUANTITY_MORALE_IMPACT"(
    "MORALE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "QUANTITY_MORALE_IMPACT" INTEGER,
    "QUANTITY_MORALE_IMPACT_KEY" INTEGER NOT NULL
);       
ALTER TABLE "PUBLIC"."MORALE_MINIGAME_QUANTITY_MORALE_IMPACT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_64" PRIMARY KEY("MORALE_MINIGAME_SHIP", "QUANTITY_MORALE_IMPACT_KEY");      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MORALE_MINIGAME_QUANTITY_MORALE_IMPACT;  
CREATE CACHED TABLE "PUBLIC"."OTHER_REQUIREMENT"(
    "NAME" VARCHAR(255) NOT NULL,
    "ACHIEVED" BOOLEAN NOT NULL,
    "DESCRIPTION" VARCHAR(255)
);    
ALTER TABLE "PUBLIC"."OTHER_REQUIREMENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E5" PRIMARY KEY("NAME");         
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.OTHER_REQUIREMENT;       
CREATE CACHED TABLE "PUBLIC"."PLANETOID_RESOURCES"(
    "PLANETOID_NAME" VARCHAR(255) NOT NULL,
    "RESOURCES" INTEGER,
    "RESOURCES_KEY" VARCHAR(255) NOT NULL
);     
ALTER TABLE "PUBLIC"."PLANETOID_RESOURCES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("PLANETOID_NAME", "RESOURCES_KEY");             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PLANETOID_RESOURCES;     
CREATE CACHED TABLE "PUBLIC"."PLAYER"(
    "ID" VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(255),
    "ROLE" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."PLAYER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");       
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.PLAYER;  
INSERT INTO "PUBLIC"."PLAYER" VALUES
('eli3n', 'Elin', 'Scientist'),
('tqipw', 'Pelle', 'Captain');         
CREATE CACHED TABLE "PUBLIC"."PLAYER_SHIP"(
    "NAME" VARCHAR(255) NOT NULL,
    "HP" INTEGER NOT NULL,
    "CREW_SIZE" INTEGER NOT NULL,
    "FACTION" VARCHAR(255),
    "MAXHP" INTEGER NOT NULL,
    "TEAM_NAME" VARCHAR(255)
);   
ALTER TABLE "PUBLIC"."PLAYER_SHIP" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A3" PRIMARY KEY("NAME");               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.PLAYER_SHIP;             
INSERT INTO "PUBLIC"."PLAYER_SHIP" VALUES
('FastShip', 10, 2, 'UNN', 10, 'Fast Boys');       
CREATE CACHED TABLE "PUBLIC"."PLAYER_SHIP_RESOURCES"(
    "PLAYER_SHIP_NAME" VARCHAR(255) NOT NULL,
    "RESOURCES" INTEGER,
    "RESOURCES_KEY" VARCHAR(255) NOT NULL
); 
ALTER TABLE "PUBLIC"."PLAYER_SHIP_RESOURCES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_79" PRIMARY KEY("PLAYER_SHIP_NAME", "RESOURCES_KEY");        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PLAYER_SHIP_RESOURCES;   
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME"(
    "SHIP" VARCHAR(255) NOT NULL,
    "EXCESS_CREW_BONUS" DOUBLE NOT NULL
);               
ALTER TABLE "PUBLIC"."REFINE_MINIGAME" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2B" PRIMARY KEY("SHIP");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME;         
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_CREW"(
    "REFINE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "ALLOCATED_CREW" INTEGER,
    "ALLOCATED_CREW_KEY" VARCHAR(255) NOT NULL
);          
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_CREW" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F65" PRIMARY KEY("REFINE_MINIGAME_SHIP", "ALLOCATED_CREW_KEY");     
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME_ALLOCATED_CREW;          
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_RAW_RESOURCE"(
    "REFINE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "ALLOCATED_RAW_RESOURCE" INTEGER,
    "ALLOCATED_RAW_RESOURCE_KEY" VARCHAR(255) NOT NULL
);  
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_RAW_RESOURCE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_32" PRIMARY KEY("REFINE_MINIGAME_SHIP", "ALLOCATED_RAW_RESOURCE_KEY");      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME_ALLOCATED_RAW_RESOURCE;  
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME_BASE_REFINEMENT_RATE"(
    "REFINE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "BASE_REFINEMENT_RATE" INTEGER,
    "BASE_REFINEMENT_RATE_KEY" VARCHAR(255) NOT NULL
);        
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_BASE_REFINEMENT_RATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9C" PRIMARY KEY("REFINE_MINIGAME_SHIP", "BASE_REFINEMENT_RATE_KEY");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME_BASE_REFINEMENT_RATE;    
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME_MINIMUM_CREW"(
    "REFINE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "MINIMUM_CREW" INTEGER,
    "MINIMUM_CREW_KEY" VARCHAR(255) NOT NULL
);
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_MINIMUM_CREW" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_EE" PRIMARY KEY("REFINE_MINIGAME_SHIP", "MINIMUM_CREW_KEY");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME_MINIMUM_CREW;            
CREATE CACHED TABLE "PUBLIC"."REFINE_MINIGAME_REFINES_INTO"(
    "REFINE_MINIGAME_SHIP" VARCHAR(255) NOT NULL,
    "REFINES_INTO" VARCHAR(255),
    "REFINES_INTO_KEY" VARCHAR(255) NOT NULL
);           
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_REFINES_INTO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("REFINE_MINIGAME_SHIP", "REFINES_INTO_KEY");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REFINE_MINIGAME_REFINES_INTO;            
CREATE CACHED TABLE "PUBLIC"."SOLAR_SYSTEM"(
    "NAME" VARCHAR(255) NOT NULL,
    "SIZE" INTEGER NOT NULL,
    "VISITED" BOOLEAN
);      
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("NAME");               
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.SOLAR_SYSTEM;            
CREATE CACHED TABLE "PUBLIC"."SOLAR_SYSTEM_CONNECTIONS"(
    "SOLAR_SYSTEM_NAME" VARCHAR(255) NOT NULL,
    "CONNECTIONS_NAME" VARCHAR(255) NOT NULL
);    
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_CONNECTIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_54" PRIMARY KEY("SOLAR_SYSTEM_NAME", "CONNECTIONS_NAME"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.SOLAR_SYSTEM_CONNECTIONS;
CREATE CACHED TABLE "PUBLIC"."SOLAR_SYSTEM_OBJECTS"(
    "SOLAR_SYSTEM_NAME" VARCHAR(255) NOT NULL,
    "OBJECTS_NAME" VARCHAR(255) NOT NULL
);            
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.SOLAR_SYSTEM_OBJECTS;    
CREATE CACHED TABLE "PUBLIC"."TEAM"(
    "NAME" VARCHAR(255) NOT NULL
);    
ALTER TABLE "PUBLIC"."TEAM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_27" PRIMARY KEY("NAME");      
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.TEAM;    
INSERT INTO "PUBLIC"."TEAM" VALUES
('Fast Boys');            
CREATE CACHED TABLE "PUBLIC"."TEAM_MEMBERS"(
    "TEAM_NAME" VARCHAR(255) NOT NULL,
    "MEMBERS_ID" VARCHAR(255) NOT NULL
);              
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.TEAM_MEMBERS;            
INSERT INTO "PUBLIC"."TEAM_MEMBERS" VALUES
('Fast Boys', 'eli3n');           
CREATE CACHED TABLE "PUBLIC"."TEST_SHIP"(
    "NAME" VARCHAR(255) NOT NULL,
    "HP" INTEGER NOT NULL,
    "CREW_SIZE" INTEGER NOT NULL,
    "FACTION" VARCHAR(255),
    "MAXHP" INTEGER NOT NULL
);    
ALTER TABLE "PUBLIC"."TEST_SHIP" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_61" PRIMARY KEY("NAME"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TEST_SHIP;               
CREATE CACHED TABLE "PUBLIC"."TRANSACTION"(
    "ID" BIGINT NOT NULL,
    "SOURCE" VARCHAR(255),
    "TIME" VARCHAR(255),
    "RECIPIENT_NAME" VARCHAR(255)
);           
ALTER TABLE "PUBLIC"."TRANSACTION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_FF" PRIMARY KEY("ID"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TRANSACTION;             
CREATE CACHED TABLE "PUBLIC"."TRANSACTION_RESOURCES"(
    "TRANSACTION_ID" BIGINT NOT NULL,
    "RESOURCES" INTEGER,
    "RESOURCES_KEY" VARCHAR(255) NOT NULL
);         
ALTER TABLE "PUBLIC"."TRANSACTION_RESOURCES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_17" PRIMARY KEY("TRANSACTION_ID", "RESOURCES_KEY");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TRANSACTION_RESOURCES;   
ALTER TABLE "PUBLIC"."CELESTIAL_BODY_SATELLITES" ADD CONSTRAINT "PUBLIC"."UK_QMLAA4W9635HC6W33V6FIW8D7" UNIQUE("SATELLITES_NAME");            
ALTER TABLE "PUBLIC"."TEAM_MEMBERS" ADD CONSTRAINT "PUBLIC"."UK_4ADET9N1MFA8WY3WBE963BT36" UNIQUE("MEMBERS_ID");              
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_OBJECTS" ADD CONSTRAINT "PUBLIC"."UK_D3QWNSHH9BU2NIAG9C5B376PP" UNIQUE("OBJECTS_NAME");    
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_CONNECTIONS" ADD CONSTRAINT "PUBLIC"."UK_CUQXM3G9P493L58F4NQROMIJN" UNIQUE("CONNECTIONS_NAME");            
ALTER TABLE "PUBLIC"."GALAXY_SOLAR_SYSTEMS" ADD CONSTRAINT "PUBLIC"."UK_8C0B4AU8VIRALLH35BY79LQHL" UNIQUE("SOLAR_SYSTEMS_NAME");              
ALTER TABLE "PUBLIC"."GATHER_MINIGAME" ADD CONSTRAINT "PUBLIC"."FK82DK5H19U0XCM9TD3KN51G3TL" FOREIGN KEY("SHIP") REFERENCES "PUBLIC"."PLAYER_SHIP"("NAME") NOCHECK;           
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_RAW_RESOURCE" ADD CONSTRAINT "PUBLIC"."FK2D5TC6FLVQYL7E1RGYBEII9W1" FOREIGN KEY("REFINE_MINIGAME_SHIP") REFERENCES "PUBLIC"."REFINE_MINIGAME"("SHIP") NOCHECK;
ALTER TABLE "PUBLIC"."PLANETOID_RESOURCES" ADD CONSTRAINT "PUBLIC"."FK7SSKUBV88YULQR1GQV695OE69" FOREIGN KEY("PLANETOID_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK;          
ALTER TABLE "PUBLIC"."TRANSACTION_RESOURCES" ADD CONSTRAINT "PUBLIC"."FKEI8VNK9YK9LNIAW578ML69XBP" FOREIGN KEY("TRANSACTION_ID") REFERENCES "PUBLIC"."TRANSACTION"("ID") NOCHECK;             
ALTER TABLE "PUBLIC"."CELESTIAL_BODY_SATELLITES" ADD CONSTRAINT "PUBLIC"."FK9CGTY5EYA8XK6LODR47S0PMJG" FOREIGN KEY("PLANETOID_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK;    
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_REFINES_INTO" ADD CONSTRAINT "PUBLIC"."FKK734LW8V5A05K2GXYPFICYDKE" FOREIGN KEY("REFINE_MINIGAME_SHIP") REFERENCES "PUBLIC"."REFINE_MINIGAME"("SHIP") NOCHECK;          
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_MINIMUM_CREW" ADD CONSTRAINT "PUBLIC"."FKLBGEXQ2L9BJAMT78KT3W3UL9O" FOREIGN KEY("GATHER_MINIGAME_SHIP") REFERENCES "PUBLIC"."GATHER_MINIGAME"("SHIP") NOCHECK;          
ALTER TABLE "PUBLIC"."CELESTIAL_BODY_SATELLITES" ADD CONSTRAINT "PUBLIC"."FKLGSCE7674APQQQEHB438M48GC" FOREIGN KEY("SATELLITES_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK;   
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_ALLOCATED_CREW" ADD CONSTRAINT "PUBLIC"."FK9JHEB89ICTAT1RHISQ498W254" FOREIGN KEY("GATHER_MINIGAME_SHIP") REFERENCES "PUBLIC"."GATHER_MINIGAME"("SHIP") NOCHECK;        
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_CONNECTIONS" ADD CONSTRAINT "PUBLIC"."FKNJECJ3AY3D9RWGRK4OTQJT413" FOREIGN KEY("SOLAR_SYSTEM_NAME") REFERENCES "PUBLIC"."SOLAR_SYSTEM"("NAME") NOCHECK;    
ALTER TABLE "PUBLIC"."TEAM_MEMBERS" ADD CONSTRAINT "PUBLIC"."FKD3E48FOD5EMKU9JU5YG1IX4M2" FOREIGN KEY("MEMBERS_ID") REFERENCES "PUBLIC"."PLAYER"("ID") NOCHECK;               
ALTER TABLE "PUBLIC"."PLAYER_SHIP" ADD CONSTRAINT "PUBLIC"."FK5D9V073HPQQG41SVQDL8IFIA2" FOREIGN KEY("TEAM_NAME") REFERENCES "PUBLIC"."TEAM"("NAME") NOCHECK; 
ALTER TABLE "PUBLIC"."CELESTIAL_BODY_FEATURES" ADD CONSTRAINT "PUBLIC"."FKMC645KPS4WXY8Q6NHTCDEOEUI" FOREIGN KEY("FEATURES_NAME") REFERENCES "PUBLIC"."FEATURE"("NAME") NOCHECK;              
ALTER TABLE "PUBLIC"."MAIN_GAME" ADD CONSTRAINT "PUBLIC"."FK1YHIUE1UUNJL2UDNUHRECD1AX" FOREIGN KEY("CURRENT_SYSTEM_NAME") REFERENCES "PUBLIC"."SOLAR_SYSTEM"("NAME") NOCHECK; 
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_MINIMUM_CREW" ADD CONSTRAINT "PUBLIC"."FKCXYOT7DHK9IG7MXGGF96RTLP4" FOREIGN KEY("REFINE_MINIGAME_SHIP") REFERENCES "PUBLIC"."REFINE_MINIGAME"("SHIP") NOCHECK;          
ALTER TABLE "PUBLIC"."TEAM_MEMBERS" ADD CONSTRAINT "PUBLIC"."FKEBPB1BV82NN9C5MJYXYXDC5WN" FOREIGN KEY("TEAM_NAME") REFERENCES "PUBLIC"."TEAM"("NAME") NOCHECK;
ALTER TABLE "PUBLIC"."MORALE_MINIGAME_QUANTITY_MORALE_IMPACT" ADD CONSTRAINT "PUBLIC"."FK5Q09656DS6694C9SQRNHPNOI6" FOREIGN KEY("MORALE_MINIGAME_SHIP") REFERENCES "PUBLIC"."MORALE_MINIGAME"("SHIP") NOCHECK;
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_OBJECTS" ADD CONSTRAINT "PUBLIC"."FK4GM7N97JUPX9YSKCRNIIT87AN" FOREIGN KEY("SOLAR_SYSTEM_NAME") REFERENCES "PUBLIC"."SOLAR_SYSTEM"("NAME") NOCHECK;        
ALTER TABLE "PUBLIC"."GATHER_MINIGAME" ADD CONSTRAINT "PUBLIC"."FK6YQWM9YOLK76TUSSWX43BE76Y" FOREIGN KEY("SOURCE_PLANET_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK;          
ALTER TABLE "PUBLIC"."MORALE_MINIGAME" ADD CONSTRAINT "PUBLIC"."FKSSDUSF4X6XJDA673T9IFV6CO9" FOREIGN KEY("SHIP") REFERENCES "PUBLIC"."PLAYER_SHIP"("NAME") NOCHECK;           
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_ALLOCATED_CREW" ADD CONSTRAINT "PUBLIC"."FK6WLNAW36Q4SLIA6D4SRPQGGFF" FOREIGN KEY("REFINE_MINIGAME_SHIP") REFERENCES "PUBLIC"."REFINE_MINIGAME"("SHIP") NOCHECK;        
ALTER TABLE "PUBLIC"."REFINE_MINIGAME" ADD CONSTRAINT "PUBLIC"."FKEKA4NOLWI77KSVYRA3GNL835E" FOREIGN KEY("SHIP") REFERENCES "PUBLIC"."PLAYER_SHIP"("NAME") NOCHECK;           
ALTER TABLE "PUBLIC"."MORALE_MINIGAME_ALLOCATED_RESOURCES" ADD CONSTRAINT "PUBLIC"."FK8PFNVRD36KOG7I3BEGQ5OE9MF" FOREIGN KEY("MORALE_MINIGAME_SHIP") REFERENCES "PUBLIC"."MORALE_MINIGAME"("SHIP") NOCHECK;   
ALTER TABLE "PUBLIC"."REFINE_MINIGAME_BASE_REFINEMENT_RATE" ADD CONSTRAINT "PUBLIC"."FK9EXNP5ON5Y3CD20C19PT42VBT" FOREIGN KEY("REFINE_MINIGAME_SHIP") REFERENCES "PUBLIC"."REFINE_MINIGAME"("SHIP") NOCHECK;  
ALTER TABLE "PUBLIC"."CELESTIAL_BODY_FEATURES" ADD CONSTRAINT "PUBLIC"."FK7J3L3OCRJCA3OH56FSP6TWMUS" FOREIGN KEY("CELESTIAL_BODY_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK; 
ALTER TABLE "PUBLIC"."GALAXY_SOLAR_SYSTEMS" ADD CONSTRAINT "PUBLIC"."FK5DFPX6QDQH7KSYXIMLDQGN33V" FOREIGN KEY("SOLAR_SYSTEMS_NAME") REFERENCES "PUBLIC"."SOLAR_SYSTEM"("NAME") NOCHECK;       
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_OBJECTS" ADD CONSTRAINT "PUBLIC"."FKEDF4SS9U0COYPRFL593BS0NHO" FOREIGN KEY("OBJECTS_NAME") REFERENCES "PUBLIC"."CELESTIAL_BODY"("NAME") NOCHECK;           
ALTER TABLE "PUBLIC"."TRANSACTION" ADD CONSTRAINT "PUBLIC"."FKME7L6QJUYSNIWHXKIE7N9PBEO" FOREIGN KEY("RECIPIENT_NAME") REFERENCES "PUBLIC"."PLAYER_SHIP"("NAME") NOCHECK;     
ALTER TABLE "PUBLIC"."GALAXY_SOLAR_SYSTEMS" ADD CONSTRAINT "PUBLIC"."FKP8LE8PGJT93F85WI6A4U2HMUP" FOREIGN KEY("GALAXY_NAME") REFERENCES "PUBLIC"."GALAXY"("NAME") NOCHECK;    
ALTER TABLE "PUBLIC"."GATHER_MINIGAME_BASE_EXTRACTION_RATE" ADD CONSTRAINT "PUBLIC"."FKLBWQVYWQ5UJ4KO8T4Q9LYM13L" FOREIGN KEY("GATHER_MINIGAME_SHIP") REFERENCES "PUBLIC"."GATHER_MINIGAME"("SHIP") NOCHECK;  
ALTER TABLE "PUBLIC"."PLAYER_SHIP_RESOURCES" ADD CONSTRAINT "PUBLIC"."FK20OPHSGK8QWULC63QLRJBCVUI" FOREIGN KEY("PLAYER_SHIP_NAME") REFERENCES "PUBLIC"."PLAYER_SHIP"("NAME") NOCHECK;         
ALTER TABLE "PUBLIC"."SOLAR_SYSTEM_CONNECTIONS" ADD CONSTRAINT "PUBLIC"."FKF7XSKD114VEVB4AAF4F4Y0M2V" FOREIGN KEY("CONNECTIONS_NAME") REFERENCES "PUBLIC"."SOLAR_SYSTEM"("NAME") NOCHECK;     