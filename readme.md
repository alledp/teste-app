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

-------
Postgres data:

->  PostgreSQL

Server: postgres_db

Username: postgres

Password: postgres
