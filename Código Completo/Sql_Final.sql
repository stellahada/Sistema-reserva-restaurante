CREATE schema exemploprojeto;
USE exemploprojeto;

CREATE TABLE Clientes(
	ID INT PRIMARY key auto_increment,
    Nome varchar(255),
    CPF VARCHAR(255),
    Email VARCHAR(255),
	Senha VARCHAR(20),
    Endereco VARCHAR(255) NOT NULL
);

CREATE TABLE Administradores (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Nome VARCHAR(255) NOT NULL,
	CPF VARCHAR(255) NOT NULL UNIQUE,
	 Email VARCHAR(255),
	Senha VARCHAR(20),
    Endereco VARCHAR(255) NOT NULL
);

CREATE TABLE Restaurantes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
	Chef VARCHAR(255) NOT NULL,
    Estrelas INT NOT NULL CHECK (Estrelas >= 0 AND Estrelas <= 5),
	Descricao VARCHAR(455) NOT NULL,
    Experiencia_Basica LONGTEXT NOT NULL,
	Experiencia_Completa LONGTEXT NOT NULL,
	Experiencia_Vip LONGTEXT NOT NULL,
    Url VARCHAR(200) NOT NULL
);
CREATE TABLE Reservas (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Nome_Cliente VARCHAR(255) NOT NULL,
	Nome_Restaurante VARCHAR(255) NOT NULL,
	Quantidade_Pessoas VARCHAR(255) NOT NULL,
	Restricao_Especial VARCHAR(255) NOT NULL,
    Tipo_Experiencia VARCHAR(255) NOT NULL,
	Dia VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL
);
drop table restaurantes;
SELECT * FROM restaurantes;
SELECT * FROM clientes;
SELECT * FROM reservas;
select * FROM restaurantes where nome = 'Paris';
