# Projeto Vida Loka

## Docker

### Comandos

- docker ps
  - lista os container que estão ativos
- docker-compose up
  - Inicializa todos os containers que estão listados no docker-compose.yml
- docker-compose down
  - Mata todos os containers que estao sendo executados via docker-compose up

- docker images
  - Lista todas as imagens de containers que foram baixadas (e estão prontas para serem utilizadas)




-------
Comandos SQL:
> select * from NOME_TABELA

Para selecionar uma determinada informação com base em um critério:
> select * from NOME_TABELA where PARAMETRO = VALOR
> Exemplo:
> select * from loja where id = 2
> select * from loja where logo = 'lelele'
> select * from loja where numero_funcionarios > 5
> 
> select * from loja where numero_funcionarios > 5 and nome = 'lalala'
>
> select * from loja where numero_funcionarios > 5 or nome = 'lalala'
> 
> select * from loja where (numero_funcionarios > 5 or nome = 'lalala') and id =1

Para utilizar as colunas especificas de uma tabela troca o * pelo nome das colunas:
> select id, nome from loja
 
Para inserir dados nas tabelas:
>insert into loja(id, nome, logo, numero_funcionarios) values (4, 'pei', 'pou', 15)

Para fazer update em uma tabela:
>update loja set nome = 'chupeta' where id = 4

>update loja set nome = 'xxx', logo = 'yyy' where numero_funcionarios >= 8

Para remover uma determinada informação do banco:
>delete from loja where id = 3

----
Para Criar uma Tabela:
> CREATE TABLE usuario(
id BIGSERIAL,
nome_usuario VARCHAR(50) NOT NULL,
nome_completo VARCHAR(100),
PRIMARY KEY(id)
);

>CREATE TABLE jogo(
id BIGSERIAL,
nome VARCHAR(50) NOT NULL,
plataforma VARCHAR(50),
valor DECIMAL DEFAULT 249.90,
PRIMARY KEY(id)
);

>INSERT INTO usuario(nome_usuario, nome_completo)
VALUES ('red','Marcelo pipo red bull');

>INSERT INTO usuario(nome_usuario, nome_completo)
VALUES ('totonho','Luis antonio');

>INSERT INTO jogo(nome, plataforma)
VALUES ('Destiny 2','PS5');

>INSERT INTO jogo(nome, plataforma, valor)
VALUES ('Final Fantasy XIV' ,'PS5', 350.90);

>CREATE TABLE usuario_jogo(
usuario_id_fk BIGINT NOT NULL,
jogo_id_fk BIGINT NOT NULL,
nota BIGINT DEFAULT 0,
PRIMARY KEY(usuario_id_fk, jogo_id_fk)
);

>ALTER TABLE usuario_jogo
ADD CONSTRAINT usuario_jogo_usuario_fk
FOREIGN KEY (usuario_id_fk)
REFERENCES usuario(id)
ON DELETE CASCADE;

>ALTER TABLE usuario_jogo
ADD CONSTRAINT usuario_jogo_jogo_fk
FOREIGN KEY (jogo_id_fk)
REFERENCES jogo(id)
ON DELETE CASCADE;


>INSERT INTO usuario_jogo (usuario_id_fk, jogo_id_fk) VALUES(1,4);
>INSERT INTO usuario_jogo (usuario_id_fk, jogo_id_fk) VALUES(2,4);
>INSERT INTO usuario_jogo (usuario_id_fk, jogo_id_fk) VALUES(2,5);

>SELECT * FROM usuario u
INNER JOIN usuario_jogo uj ON u.id = uj.usuario_id_fk
INNER JOIN jogo j ON j.id = uj.jogo_id_fk
WHERE
u.id = 1

>SELECT j.nome, j.plataforma, j.valor, uj.nota FROM usuario u
INNER JOIN usuario_jogo uj ON u.id = uj.usuario_id_fk
INNER JOIN jogo j ON j.id = uj.jogo_id_fk
WHERE
u.id = 1


-------
Postgres data:

->  PostgreSQL

Server: postgres_db

Username: postgres

Password: postgres
