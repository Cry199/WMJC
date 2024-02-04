-- H2 2.1.214;
;             
CREATE USER IF NOT EXISTS "SA" SALT 'c22bffc16fce1b13' HASH '7953f523c277453e6eeb647c386dfcef105710619cdd1d67e23bde9350308202' ADMIN;         
CREATE MEMORY TABLE "PUBLIC"."PERFIL_DO_USARIO"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 123) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "NOMEDOPERFIL" CHARACTER VARYING(255),
    "IMGFERFIL" CHARACTER VARYING(255),
    "TIPODEUSER" ENUM('admin', 'user') NOT NULL
);      
ALTER TABLE "PUBLIC"."PERFIL_DO_USARIO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("ID");             
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.PERFIL_DO_USARIO;        
INSERT INTO "PUBLIC"."PERFIL_DO_USARIO" VALUES
(1, 1, 'LL', 'https://i.pinimg.com/originals/bf/62/e1/bf62e18d04c5a61c26683dd34be9d2ff.gif', 'user'),
(2, 2, 'Maria', 'https://i.pinimg.com/564x/06/33/bc/0633bc914d7ba9f6446840f5351f040b.jpg', 'admin'),
(3, 3, 'PerfilCarlos', 'https://i.pinimg.com/564x/80/a7/be/80a7be7b17dd175244fca8f8fa714e18.jpg', 'user'),
(5, 18, 'Id 18 Teste', 'https://i.pinimg.com/originals/97/6d/86/976d86469700009550fda1098423cd5e.gif', 'user');      
CREATE MEMORY TABLE "PUBLIC"."JOGOS"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 4) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "NOMEDOJOGO" CHARACTER VARYING(255),
    "NOMEDATABALADOJOGO" CHARACTER VARYING(255),
    "DESCRICAODOJOGO" CHARACTER VARYING(255),
    "CAPADOJOGO" CHARACTER VARYING(255)
);     
ALTER TABLE "PUBLIC"."JOGOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ID");        
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.JOGOS;   
INSERT INTO "PUBLIC"."JOGOS" VALUES
(1, 1, 'Crash 2', 'Crash', U&'Crash Bandicoot \00e9 uma franquia de jogos eletr\00f4nicos de plataforma desenvolvida originalmente pela Naughty Dog para o console da PlayStation. A s\00e9rie passou por v\00e1rias desenvolvedoras e foi publicada em diversas plataformas posteriormente.', 'https://i.pinimg.com/564x/c8/09/2c/c8092cef75614edd6b0a8293248eec80.jpg'),
(2, 2, 'seila ', 'Tabela2', 'sasa', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fbr.pinterest.com%2Fmilereis49%2Fmulheres-coreanas%2F&psig=AOvVaw2Vc8PaGgWUH52kImd_nMIc&ust=1707155157372000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIjJ_9eekoQDFQAAAAAdAAAAABAE'),
(3, 3, 'Jogo3', 'Tabela3', U&'Descri\00e7\00e3o do Jogo 3', 'https://i.pinimg.com/564x/22/a6/fa/22a6fab993e2848bdad48f0a5ca78387.jpg');               
CREATE MEMORY TABLE "PUBLIC"."COMENTARIOSPERFIL"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 70) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "IDPERFIL" INTEGER NOT NULL,
    "COMENTARIO" CHARACTER VARYING
);      
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("ID");            
-- 28 +/- SELECT COUNT(*) FROM PUBLIC.COMENTARIOSPERFIL;      
INSERT INTO "PUBLIC"."COMENTARIOSPERFIL" VALUES
(1, 1, 1, U&'Coment\00e1rio 1'),
(2, 2, 2, U&'Coment\00e1rio 2'),
(3, 3, 3, U&'Coment\00e1rio 3'),
(4, 1, 2, U&'Coment\00e1rio 12'),
(5, 1, 2, U&'Coment\00e1rio 1'),
(6, 1, 3, U&'Coment\00e1rio 1'),
(7, 2, 1, U&'Coment\00e1rio 1'),
(8, 3, 1, U&'Coment\00e1rio 1'),
(9, 2, 1, U&'Coment\00e1rio 1'),
(10, 1, 1, U&'Coment\00e1rio 1'),
(11, 3, 1, U&'Coment\00e1rio 1'),
(53, 18, 5, 'Re'),
(54, 18, 5, 're'),
(55, 18, 5, 're'),
(56, 18, 5, 're'),
(57, 18, 5, 'Aqui'),
(58, 18, 5, 'r'),
(59, 1, 1, 'Re'),
(60, 18, 5, 'rr'),
(61, 1, 1, 'Tste'),
(62, 1, 5, 'Tes'),
(63, 1, 5, 'Tes'),
(64, 1, 3, 'E isso'),
(65, 1, 5, 'Re'),
(66, 1, 5, 'Re'),
(67, 1, 5, 'Re'),
(68, 1, 5, '11'),
(69, 18, 5, '11');  
CREATE MEMORY TABLE "PUBLIC"."COMENTARIODEJOGO"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "IDJOGO" INTEGER NOT NULL,
    "COMENTARIO" CHARACTER VARYING
);         
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1E" PRIMARY KEY("ID");            
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.COMENTARIODEJOGO;       
INSERT INTO "PUBLIC"."COMENTARIODEJOGO" VALUES
(1, 1, 1, U&'Coment\00e1rio 1'),
(2, 2, 2, U&'Coment\00e1rio 2'),
(3, 3, 3, U&'Coment\00e1rio 3'),
(4, 1, 1, U&'Coment\00e1rio 12'),
(5, 2, 1, U&'Coment\00e1rio 22'),
(6, 3, 1, U&'Coment\00e1rio 32'),
(7, 5, 2, 'e isso'),
(8, 5, 2, 'ddd'),
(9, 5, 3, 'Ez'),
(10, 5, 3, 'Apenas');               
CREATE MEMORY TABLE "PUBLIC"."USE"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 22) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL,
    "SOBRENOME" CHARACTER VARYING(255),
    "SENHA" CHARACTER VARYING(255) NOT NULL,
    "EMAIL" CHARACTER VARYING(255),
    "TIPODEUSARIO" ENUM('admin', 'user') NOT NULL,
    "USERNAME" CHARACTER VARYING(255)
);        
ALTER TABLE "PUBLIC"."USE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");          
-- 15 +/- SELECT COUNT(*) FROM PUBLIC.USE;    
INSERT INTO "PUBLIC"."USE" VALUES
(1, U&'Jo\00e3o', 'Silva', 'senha123', 'joao@gmail.com', 'user', U&'Jo\00e3o123'),
(2, 'Maria', 'Santos', 'senha456', 'maria@gmail.com', 'admin', 'N/A'),
(3, 'Carlos', 'Oliveira', 'senha789', 'carlos@gmail.com', 'user', 'N/A'),
(4, 'teste', 'teste', 'teste', 'teste', 'user', 'N/A'),
(5, 'teste', 'Sobteste', 'teste', 'teste', 'user', 'N/A'),
(6, U&'Jo\00e3o', 'Silva', 'senha123', 'joao@gmail.com', 'user', 'N/A'),
(7, U&'Jo\00e3o1', 'Silva', 'senha123', 'joao@gmail.com', 'user', 'N/A'),
(8, U&'Jo\00e3o', 'Silva', 'senha123', 'joao@gmail.com', 'user', NULL),
(9, 'Carlos', 'Oliveira', 'senha789', 'carlos@gmail.com', 'user', NULL),
(10, 'Carlos', 'Oliveira', 'senha789', 'carlos@gmail.com', 'user', 'CarlosOliveira'),
(11, 'Teste', 'Test1', 'teste', 'carlos@gmail.com', 'user', 'TesteTest1'),
(18, 'sa', 'sa', 'sa', 'sa', 'user', 'sasa'),
(19, 'Caua', 'Ribeiro', 'sa', 'sa', 'user', 'CauaRibeiro'),
(20, 'Caua', 'Ribeiro', 'Sa1', 'sa1', 'user', 'CauaRibeiro'),
(21, 'Gui', '2', '2', '2', 'user', 'Gui2');              
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1EE" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."PERFIL_DO_USARIO"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E92" FOREIGN KEY("IDPERFIL") REFERENCES "PUBLIC"."PERFIL_DO_USARIO"("ID") NOCHECK;               
ALTER TABLE "PUBLIC"."PERFIL_DO_USARIO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_FB" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;              
ALTER TABLE "PUBLIC"."JOGOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_43" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;         
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1EE0" FOREIGN KEY("IDJOGO") REFERENCES "PUBLIC"."JOGOS"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E9" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;             
CREATE FORCE TRIGGER "PUBLIC"."BEFORE_USER_INSERT" BEFORE INSERT ON "PUBLIC"."USE" FOR EACH ROW QUEUE 1024 CALL 'br.com.wmjc.db.trigger.TriggerUserName';     
