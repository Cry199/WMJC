-- H2 2.1.214;
;             
CREATE USER IF NOT EXISTS "SA" SALT '4c832e925108a43d' HASH '001515bae32f21ad78f3a03c7e3d7ffd8e6033ef70c04d5e65e6bdafcae97226' ADMIN;         
CREATE MEMORY TABLE "PUBLIC"."PERFIL_DO_USARIO"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 130) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "NOMEDOPERFIL" CHARACTER VARYING(255),
    "IMGFERFIL" CHARACTER VARYING(255),
    "TIPODEUSER" ENUM('admin', 'user') NOT NULL
);      
ALTER TABLE "PUBLIC"."PERFIL_DO_USARIO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("ID");             
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.PERFIL_DO_USARIO;        
INSERT INTO "PUBLIC"."PERFIL_DO_USARIO" VALUES
(1, 1, 'Cry', 'https://i.pinimg.com/originals/b7/74/31/b774312c2fd5ef61bcb101e0b1656559.gif', 'user'),
(2, 2, 'Maria', 'https://i.pinimg.com/564x/06/33/bc/0633bc914d7ba9f6446840f5351f040b.jpg', 'admin'),
(3, 3, 'PerfilCarlos', 'https://i.pinimg.com/564x/80/a7/be/80a7be7b17dd175244fca8f8fa714e18.jpg', 'user'),
(5, 18, 'Sa', 'https://i.pinimg.com/originals/d5/25/e4/d525e465c8639fa7fcfcf84b5ec80fb9.gif', 'user'),
(126, 5, NULL, NULL, 'user'),
(129, 22, 'GIPHY', 'https://i.pinimg.com/originals/e3/33/ab/e333abb4204cec74ed091568d2481dc1.gif', 'user');  
CREATE MEMORY TABLE "PUBLIC"."JOGOS"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 17) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "NOMEDOJOGO" CHARACTER VARYING(255),
    "NOMEDATABALADOJOGO" CHARACTER VARYING(255),
    "DESCRICAODOJOGO" CHARACTER VARYING(255),
    "CAPADOJOGO" CHARACTER VARYING(255)
);    
ALTER TABLE "PUBLIC"."JOGOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ID");        
-- 12 +/- SELECT COUNT(*) FROM PUBLIC.JOGOS;  
INSERT INTO "PUBLIC"."JOGOS" VALUES
(1, 1, 'Crash', 'Crash', U&'Crash Bandicoot \00c3\00a9 uma franquia de jogos eletr\00c3\00b4nicos de plataforma desenvolvida originalmente pela Naughty Dog para o console da PlayStation. A s\00c3\00a9rie passou por v\00c3\00a1rias desenvolvedoras e foi publicada em diversas plataformas posteriormente.', 'https://i.pinimg.com/564x/c8/09/2c/c8092cef75614edd6b0a8293248eec80.jpg'),
(2, 1, 'PalWord', 'Tabela2', 'Pals', 'https://i.pinimg.com/originals/3c/66/7f/3c667f6c5e88aec4f092f87a9e7a1159.gif'),
(3, 1, 'Jogo3', 'Tabela3', U&'Descri\00e7\00e3o do Jogo 3', 'https://i.pinimg.com/564x/22/a6/fa/22a6fab993e2848bdad48f0a5ca78387.jpg'),
(4, 1, 'The Legend of Zelda: Breath of the Wild', 'Tabela4', U&'Um jogo de a\00e7\00e3o e aventura onde os jogadores podem explorar o reino de Hyrule enquanto controlam Link.', 'https://i.pinimg.com/564x/42/93/61/4293616bf7f55e19935918a349e70577.jpg'),
(5, 1, 'Super Mario Odyssey', 'Tabela5', U&'Jogo de plataforma onde os jogadores controlam Mario enquanto ele viaja por v\00e1rios mundos para resgatar a Princesa Peach de Bowser.', 'https://i.pinimg.com/564x/d5/b3/3a/d5b33ae1ed2f66c5da9bedd7f4868024.jpg'),
(6, 1, 'Minecraft', 'Tabela6', 'Jogo de sandbox que permite aos jogadores construir e destruir diferentes tipos de blocos em um mundo tridimensional.', 'https://i.pinimg.com/originals/45/21/e0/4521e03e7f7692ec9f1be8a748d266d6.gif'),
(8, 1, 'Among Us', 'Tabela8', U&'Jogo de festa online multiplayer onde os jogadores devem trabalhar juntos para completar tarefas, mas alguns jogadores s\00e3o impostores tentando matar a tripula\00e7\00e3o.', 'https://i.pinimg.com/originals/05/8e/fa/058efa2ae3aa1d881d33daca2db63fd6.gif'),
(10, 1, 'FIFA 21', 'Tabela10', U&'Jogo de simula\00e7\00e3o de futebol onde os jogadores podem controlar times reais e jogadores de todo o mundo.', 'https://i.pinimg.com/originals/27/6d/8a/276d8a10cee119716d3322f902cdee4e.gif'),
(11, 1, 'Animal Crossing: New Horizons', 'Tabela11', U&'Jogo de simula\00e7\00e3o de vida onde os jogadores podem explorar e personalizar sua pr\00f3pria ilha deserta.', 'https://i.pinimg.com/originals/1a/4c/5b/1a4c5bb4855f4d06caa78471692c5f9a.gif'),
(14, 1, 'Teste', 'teste', 'TEste', 'https://i.pinimg.com/originals/aa/bd/36/aabd36b3af032ae26a489ad9ae984bcb.gif'),
(15, 18, 'Helltaker', 'helltaker', 'Teste', 'https://i.pinimg.com/originals/f1/23/7d/f1237d93b0a969e7a1d50049d9bd3a01.gif'),
(16, 1, 'INMOST', 'inmost', 'INMOST is an atmospheric, story-driven puzzle platformer, following three playable characters within one interconnecting story.', 'https://i.pinimg.com/originals/46/b1/32/46b13253b3a90888cc60d576e725ff51.gif');        
CREATE MEMORY TABLE "PUBLIC"."COMENTARIOSPERFIL"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 94) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "IDPERFIL" INTEGER NOT NULL,
    "COMENTARIO" CHARACTER VARYING
);      
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("ID");            
-- 18 +/- SELECT COUNT(*) FROM PUBLIC.COMENTARIOSPERFIL;      
INSERT INTO "PUBLIC"."COMENTARIOSPERFIL" VALUES
(1, 1, 1, U&'Coment\00e1rio 1'),
(3, 3, 3, U&'Coment\00e1rio 3'),
(6, 1, 3, U&'Coment\00e1rio 1'),
(7, 2, 1, U&'Coment\00e1rio 1'),
(8, 3, 1, U&'Coment\00e1rio 1'),
(9, 2, 1, U&'Coment\00e1rio 1'),
(10, 1, 1, U&'Coment\00e1rio 1'),
(11, 3, 1, U&'Coment\00e1rio 1'),
(59, 1, 1, 'Re'),
(71, 18, 1, '12'),
(81, 18, 5, 'aaa'),
(84, 2, 5, 'ZZZZ'),
(86, 22, 129, 'dad'),
(87, 22, 5, 'sdasd'),
(88, 22, 1, 'AA'),
(90, 22, 3, 'dasda'),
(91, 18, 2, 'TT'),
(93, 18, 129, 'DDD');        
CREATE MEMORY TABLE "PUBLIC"."COMENTARIODEJOGO"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 36) NOT NULL,
    "IDDOUSER" INTEGER NOT NULL,
    "IDJOGO" INTEGER NOT NULL,
    "COMENTARIO" CHARACTER VARYING
);         
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1E" PRIMARY KEY("ID");            
-- 26 +/- SELECT COUNT(*) FROM PUBLIC.COMENTARIODEJOGO;       
INSERT INTO "PUBLIC"."COMENTARIODEJOGO" VALUES
(1, 1, 1, U&'Coment\00e1rio 1'),
(2, 2, 2, U&'Coment\00e1rio 2'),
(3, 3, 3, U&'Coment\00e1rio 3'),
(6, 3, 1, U&'Coment\00e1rio 32'),
(7, 5, 2, 'e isso'),
(8, 5, 2, 'ddd'),
(9, 5, 3, 'Ez'),
(10, 5, 3, 'Apenas'),
(12, 1, 2, 'Apenas'),
(15, 5, 3, 'Resident Evil 4'),
(16, 1, 14, 'rere'),
(17, 5, 15, 'Helltaker'),
(18, 5, 15, 'Helltaker'),
(19, 5, 15, 'Helltaker1 1'),
(21, 5, 1, 'Foi'),
(22, 5, 1, 'Apenas'),
(24, 2, 15, 'ZZZZZ'),
(26, 129, 4, 'sdasd'),
(27, 129, 4, 'asda'),
(28, 129, 15, 'Aaa'),
(29, 129, 14, 'aaa'),
(30, 1, 1, 'aa'),
(32, 1, 15, 'dsda'),
(33, 1, 16, U&'Mds que bom (\00ef\00bf\00a3y\00e2\0096\00bd,\00ef\00bf\00a3)\00e2\0095\00ad '),
(34, 5, 16, 'Mds que jogo Hor'),
(35, 5, 1, 'aaa');     
CREATE MEMORY TABLE "PUBLIC"."USE"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 23) NOT NULL,
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
(2, 'Maria', 'Santos', 'senha456', 'maria@gmail.com', 'admin', 'Maria2'),
(3, 'Carlos', 'Oliveira', 'senha789', 'carlos@gmail.com', 'user', 'Carlos30'),
(4, 'teste', 'teste', 'teste', 'teste', 'user', 'Teste13'),
(5, 'teste', 'Sobteste', 'teste', 'teste', 'user', 'SobreTeste'),
(6, U&'Jo\00e3o', 'Silva', 'senha123', 'joao@gmail.com', 'user', 'Jo\00e3oSilva'),
(7, U&'Jo\00e3o1', 'Silva', 'senha123', 'joao@gmail.com', 'user', 'Jo\00e3oSilva1'),
(8, U&'Jo\00e3o', 'Silva', 'senha123', 'joao@gmail.com', 'user', 'Jo\00e3oSilva2'),
(9, 'Carlos', 'Oliveira', 'senha789', 'carlos@gmail.com', 'user', 'CarlosOliveira1'),
(11, 'Teste', 'Test1', 'teste', 'carlos@gmail.com', 'user', 'TesteTest1'),
(18, 'sa', 'sa', 'sa', 'sa', 'user', 'Sa'),
(19, 'Caua', 'Ribeiro', 'sa', 'sa', 'user', 'CauaRibeiro'),
(20, 'Caua', 'Ribeiro', 'Sa1', 'sa1', 'user', 'CauaRibeiro'),
(21, 'Gui', '2', '2', '2', 'user', 'Gui2'),
(22, 'testAdmin', 'testAdmin', 'testAdmin', 'testAdmin', 'admin', 'testAdmintestAdmin');            
CREATE MEMORY TABLE "PUBLIC"."CRASH"(
    "ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 2) NOT NULL,
    "TEXTO" CHARACTER VARYING(255) NOT NULL,
    "OP1" CHARACTER VARYING NOT NULL,
    "REF1" INTEGER NOT NULL,
    "OP2" CHARACTER VARYING NOT NULL,
    "REF2" INTEGER NOT NULL,
    "OP3" CHARACTER VARYING NOT NULL,
    "REF3" INTEGER NOT NULL,
    "IMAGE" CHARACTER VARYING NOT NULL
);      
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.CRASH;   
INSERT INTO "PUBLIC"."CRASH" VALUES
(1, '1', '1', 1, '1', 1, '1', 1, 'https://i.pinimg.com/originals/d1/72/02/d17202b45b42ba5fd7cce2f2ae298881.gif');        
CREATE MEMORY TABLE "PUBLIC"."HISTORICO_DE_JOGADAS"(
    "ID_JOGADA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "ID_USUARIO" INTEGER NOT NULL,
    "ID_DO_JOGO" INTEGER NOT NULL,
    "DATA_HORA" TIMESTAMP NOT NULL
);        
ALTER TABLE "PUBLIC"."HISTORICO_DE_JOGADAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_13" PRIMARY KEY("ID_JOGADA"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.HISTORICO_DE_JOGADAS;    
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E92" FOREIGN KEY("IDPERFIL") REFERENCES "PUBLIC"."PERFIL_DO_USARIO"("ID") NOCHECK;               
ALTER TABLE "PUBLIC"."JOGOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_43" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;         
ALTER TABLE "PUBLIC"."HISTORICO_DE_JOGADAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_138" FOREIGN KEY("ID_USUARIO") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;       
ALTER TABLE "PUBLIC"."HISTORICO_DE_JOGADAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_138F" FOREIGN KEY("ID_DO_JOGO") REFERENCES "PUBLIC"."JOGOS"("ID") NOCHECK;    
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1EE" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."PERFIL_DO_USARIO"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."PERFIL_DO_USARIO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_FB" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;              
ALTER TABLE "PUBLIC"."COMENTARIODEJOGO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1EE0" FOREIGN KEY("IDJOGO") REFERENCES "PUBLIC"."JOGOS"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."COMENTARIOSPERFIL" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E9" FOREIGN KEY("IDDOUSER") REFERENCES "PUBLIC"."USE"("ID") NOCHECK;             
CREATE FORCE TRIGGER "PUBLIC"."BEFORE_USER_INSERT" BEFORE INSERT ON "PUBLIC"."USE" FOR EACH ROW QUEUE 1024 CALL 'br.com.wmjc.db.trigger.TriggerUserName';     
