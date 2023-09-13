CREATE DATABASE db_lds WITH OWNER = postgres
ENCODING = 'UTF8' CONNECTION LIMIT = -1;

DROP TABLE comentario;
DROP TABLE usuario_jogo;
DROP TABLE imagem_jogo;
DROP TABLE jogo;
DROP TABLE usuario;


CREATE TABLE usuario
(
    id BIGSERIAL,
    nome_usuario VARCHAR (50) UNIQUE NOT NULL,
    senha VARCHAR (50) NOT NULL,
    nome_completo VARCHAR (100) NOT NULL,
    email VARCHAR (50) NOT NULL,
    tipo VARCHAR (30) NOT NULL,
    esta_ativo BOOLEAN NOT NULL DEFAULT true,
    data_nascimento TIMESTAMP NOT NULL,
    ultimo_acesso TIMESTAMP NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    avatar bytea,
    PRIMARY KEY(id)
);

CREATE TABLE jogo
(
    id BIGSERIAL,
    genero VARCHAR (50) NOT NULL,
    nome VARCHAR (50) UNIQUE NOT NULL,
    descricao VARCHAR NOT NULL,
    preco DECIMAL DEFAULT 349.90,
    desenvolvido_por VARCHAR (100) NOT NULL,
    data_lancamento VARCHAR (50) DEFAULT '-',
    plataforma VARCHAR (50) NOT NULL,
    imagem_principal VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE imagem_jogo
(
    id BIGSERIAL,
    jogo_id_fk BIGINT NOT NULL,
    imagem VARCHAR,
    PRIMARY KEY(id)
);

ALTER TABLE imagem_jogo
ADD CONSTRAINT imagem_jogo_jogo_fk
FOREIGN KEY (jogo_id_fk)
REFERENCES jogo (id)
ON DELETE CASCADE;

CREATE TABLE usuario_jogo
(
    usuario_id_fk BIGINT NOT NULL,
    jogo_id_fk BIGINT NOT NULL,
    nota BIGINT NOT NULL,
    PRIMARY KEY(usuario_id_fk, jogo_id_fk)
);

--ALTER TABLE usuario_jogo
--ADD CONSTRAINT usuario_jogo_usuario_fk
--FOREIGN KEY (usuario_id_fk)
--REFERENCES usuario (id)
--ON DELETE SET NULL;
--
--ALTER TABLE usuario_jogo
--ADD CONSTRAINT usuario_jogo_jogo_fk
--FOREIGN KEY (jogo_id_fk)
--REFERENCES jogo (id)
--ON DELETE SET NULL;

CREATE TABLE comentario
(
    id BIGSERIAL,
    jogo_id_fk BIGINT NOT NULL,
    usuario_id_fk BIGINT NOT NULL,
    enviado_em TIMESTAMP NOT NULL,
    texto_do_comentario VARCHAR (300) NOT NULL,
    PRIMARY KEY(id)
);

--ALTER TABLE comentario
--ADD CONSTRAINT comentario_jogo_fk
--FOREIGN KEY (jogo_id_fk)
--REFERENCES jogo (id)
--ON DELETE SET NULL;
--
--ALTER TABLE comentario
--ADD CONSTRAINT comentario_usuario_fk
--FOREIGN KEY (usuario_id_fk)
--REFERENCES usuario (id)
--ON DELETE SET NULL;



---------------------
INSERT INTO usuario
(nome_usuario, senha, nome_completo, email, tipo, data_nascimento, ultimo_acesso, criado_em)
VALUES
('admin', 'admin', 'Administrador', 'admin@gmail.com', 'ADMINISTRADOR', '1985-02-02 21:00:00-03', now(), now());

INSERT INTO usuario
(nome_usuario, senha, nome_completo, email, tipo, data_nascimento, ultimo_acesso, criado_em)
VALUES
('tiburssinho', '123456', 'Tiburssin Tiburssius', 'tibursinho@gmail.com', 'CLIENTE', '1985-04-04 21:00:00-03', now(), now());

INSERT INTO usuario
(nome_usuario, senha, nome_completo, email, tipo, data_nascimento, ultimo_acesso, criado_em)
VALUES
('aroldo', '123456', 'Aroldo Aroldus', 'aroldo@gmail.com', 'CLIENTE', '1988-01-01 19:00:00-03', now(), now());
---------------------

---------------------
INSERT INTO jogo
(genero, nome, descricao, desenvolvido_por, plataforma)
VALUES
('MMORPG', 'Final Fantasy XIV', 'Joguin que o red n quer jogar', 'Square', 'PSX');

INSERT INTO jogo
(genero, nome, descricao, desenvolvido_por, plataforma)
VALUES
('GACHA', 'Grand Summoners', 'Joguin que deixa geral frustrado', 'NEXT NINJA', 'MOBILE');

INSERT INTO jogo
(genero, nome, descricao, desenvolvido_por, plataforma)
VALUES
('SHOOTER', 'CS', 'Joguin que o red tomava hs do pipo', 'VALVE', 'PC');
---------------------

---------------------
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, texto_do_comentario)
VALUES
(1,1, now(), 'Comentário 01 do jogo 01 - usuario 01');

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, texto_do_comentario)
VALUES
(1,2, now(), 'Comentário 02 do jogo 01 - usuario 02');

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, texto_do_comentario)
VALUES
(2,3, now(), 'Comentário 03 do jogo 02 - usuario 03');

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, texto_do_comentario)
VALUES
(2,1, now(), 'Comentário 04 do jogo 02 - usuario 01');
---------------------