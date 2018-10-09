/**
 * Author:  Sara Reis
 * Created: 09/10/2018
 */

DROP DATABASE IF EXISTS sara;
CREATE DATABASE sara;
use sara;

CREATE TABLE filmes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    diretor VARCHAR(100),
    categoria VARCHAR(30),
    ator_principal VARCHAR(100),
    ano smallint,
    duracao smallint,
    classificao_Indicativa VARCHAR(5),
    idioma_original VARCHAR(20),
    legendado boolean,
    dublado boolean,
    orcamento double,
    faturamento double
);

SELECT * FROM filmes;