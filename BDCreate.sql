-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

-- Tabela Endereco
CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep INT,
    rua VARCHAR(255),
    complemento VARCHAR(255),
    logradouro VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    numero INT
);

-- Tabela Vendedor
CREATE TABLE vendedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    cnpj VARCHAR(18) UNIQUE,
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    telefone VARCHAR(15),
    dataNascimento DATE,
    nacionalidade VARCHAR(50),
    genero VARCHAR(10),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
);

-- Tabela Produto
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descricao TEXT,
    valor DOUBLE,
    estoque INT,
    vendedor_id INT,
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE
);

-- Tabela Cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    telefone VARCHAR(15),
    dataNascimento DATE,
    nacionalidade VARCHAR(50),
    genero VARCHAR(10),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
);

-- Tabela Carrinho
CREATE TABLE carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechado boolean,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Tabela Item
CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidadeItem INT,
    subTotal DOUBLE,
    produto_id INT,
    carrinho_id INT,
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE SET NULL
);

-- Tabela Avaliacao
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nota INT,
    comentario TEXT,
    data DATE,
    cliente_id INT,
    produto_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE SET NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
);

-- Tabela Pedido
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    precoTotal DOUBLE,
    dataPedido DATE,
    tipoPagamento INT,
    carrinho_id INT,
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(id) ON DELETE CASCADE
);
