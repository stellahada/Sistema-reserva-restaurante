CREATE TABLE Pessoa (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Nome VARCHAR(255) NOT NULL,
  CPF VARCHAR(255) NOT NULL UNIQUE,
  Endereco VARCHAR(255) NOT NULL
);

CREATE TABLE Clientes(
	ID INT PRIMARY key auto_increment,
    Nome varchar(255),
    CPF VARCHAR(255),
    Endereco VARCHAR(255) NOT NULL,
    Pessoa_id INT NOT NULL,
	FOREIGN KEY (Pessoa_id) REFERENCES Pessoa(ID)
);

CREATE TABLE Administradores (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Nome VARCHAR(255) NOT NULL,
	CPF VARCHAR(255) NOT NULL UNIQUE,
	Endereco VARCHAR(255) NOT NULL,
	Pessoa_id INT NOT NULL,
	FOREIGN KEY (Pessoa_id) REFERENCES Pessoa(ID)
);

CREATE TABLE Restaurantes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Endereco VARCHAR(255) NOT NULL,
    Estrelas INT NOT NULL CHECK (Estrelas >= 0 AND Estrelas <= 5),
    Experiencia VARCHAR(255) NOT NULL,
    Mesas VARCHAR(255) NOT NULL,
    Imagem VARCHAR(300) NOT NULL
);

CREATE TABLE Experiencias (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Nome VARCHAR(255) NOT NULL,
  Chef VARCHAR(255) NOT NULL,
  Preco DOUBLE NOT NULL,
  Menu VARCHAR(255) NOT NULL,
  Tipo VARCHAR(255) NOT NULL,
  Descricao TEXT NOT NULL
);

CREATE TABLE Restaurante_experiencia (
  Restaurante_id INT NOT NULL,
  Experiencia_id INT NOT NULL,
  PRIMARY KEY (Restaurante_ID, experiencia_id),
  FOREIGN KEY (Restaurante_ID) REFERENCES Restaurantes(ID),
  FOREIGN KEY (Experiencia_ID) REFERENCES Experiencia(ID)
);

CREATE TABLE Reservas (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Cliente_id INT NOT NULL,
  Data_hora_reserva DATETIME NOT NULL,
  Mesas VARCHAR(255) NOT NULL,
  status ENUM('Aberta', 'Confirmada', 'Cancelada'),
  Restaurante_id INT NOT NULL,
  FOREIGN KEY (Cliente_id) REFERENCES Clientes(ID),
  FOREIGN KEY (Restaurante_id) REFERENCES Restaurantes(ID)
);


CREATE TABLE Cadastro_mesa (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Dia DATE NOT NULL,
  Hora TIME NOT NULL,
  Mesas VARCHAR(255) NOT NULL
);

CREATE TABLE Relatorio_vendas (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Num_reservas INT NOT NULL,
    Receita DOUBLE NOT NULL,
	Cliente_id INT NOT NULL,
	Restaurante_id INT NOT NULL,
	FOREIGN KEY (Cliente_id) REFERENCES Clientes(ID),
	FOREIGN KEY (Restaurante_id) REFERENCES Restaurantes(ID)
);

