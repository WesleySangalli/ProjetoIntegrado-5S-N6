create table Dificuldade(
    ID_DIFICULDADE SERIAL PRIMARY KEY,
    DESCRICAO TEXT NOT NULL
);

Create table Usuario(
	ID_USUARIO SERIAL PRIMARY KEY,
    NOME_USUARIO TEXT NOT NULL
);

create table UsuarioxPontuacao(
	ID_USUARIO INTEGER REFERENCES Usuario (ID_USUARIO) ,
    PONTUACAO INTEGER   
);

create table Palavras(
 	ID_PALAVRA SERIAL PRIMARY KEY, 
    PALAVRA TEXT NOT NULL, 
    ID_DIFICULDADE INTEGER REFERENCES DIFICULDADE (ID_DIFICULDADE) NOT NULL
);

INSERT INTO DIFICULDADE(DESCRICAO) VALUES ('FÁCIL');
INSERT INTO DIFICULDADE(DESCRICAO) VALUES ('MÉDIO');
INSERT INTO DIFICULDADE(DESCRICAO) VALUES ('DIFICÍL');

INSERT INTO palavras(palavra, id_dificuldade) VALUES ('MACACO', 1);
INSERT INTO palavras(palavra, id_dificuldade) VALUES ('TELEGRAMA', 2);
INSERT INTO palavras(palavra, id_dificuldade) VALUES ('ALTO-FALANTE', 3);