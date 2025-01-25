-- Criação do banco de dados se não existir
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    nascimento DATE,
    nacionalidade VARCHAR(100),
    genero ENUM('Masculino', 'Feminino', 'Outro'),
    endereco TEXT
);

-- Tabela Vendedor
CREATE TABLE IF NOT EXISTS Vendedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    cnpj VARCHAR(14) UNIQUE,
    telefone VARCHAR(15),
    nacionalidade VARCHAR(100)
);

-- Tabela Usuario
CREATE TABLE IF NOT EXISTS Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    idPessoa INT NOT NULL,
    tipoPessoa ENUM('Cliente', 'Vendedor') NOT NULL, -- Define se a pessoa é cliente ou vendedor
    UNIQUE (email)
);

-- Tabela Produto
CREATE TABLE IF NOT EXISTS Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    valor DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL CHECK (estoque >= 0)
);

-- Tabela Item (Relacionada com Produto)
CREATE TABLE IF NOT EXISTS Item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idProduto INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (idProduto) REFERENCES Produto(id) ON DELETE CASCADE
);

-- Tabela Carrinho
CREATE TABLE IF NOT EXISTS Carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idItem INT NOT NULL,
    idCliente INT,
	FOREIGN KEY (idCliente) REFERENCES Cliente(id) ON DELETE CASCADE,
    FOREIGN KEY (idItem) REFERENCES Item(id) ON DELETE CASCADE
);

-- Tabela Pedido (Relacionada com Carrinho)
CREATE TABLE IF NOT EXISTS Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    finalizado BOOLEAN DEFAULT FALSE,
    precoTotal DECIMAL(10, 2) DEFAULT 0.00,
    dataPedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipoPagamento ENUM('Cartão de Crédito', 'Boleto', 'Pix', 'Dinheiro') NOT NULL,
    idCarrinho INT NOT NULL,
    FOREIGN KEY (idCarrinho) REFERENCES Carrinho(id) ON DELETE CASCADE
);

-- Tabela Avaliacao (Relacionada com Cliente)
CREATE TABLE IF NOT EXISTS Avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nota INT CHECK (nota >= 1 AND nota <= 5),
    comentario TEXT,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id) ON DELETE CASCADE
);
