-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

-- Tabela Endereco
CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do endereço',
    cep INT COMMENT 'Código de Endereçamento Postal (CEP)',
    rua VARCHAR(255) COMMENT 'Nome da rua',
    complemento VARCHAR(255) COMMENT 'Informações complementares do endereço',
    logradouro VARCHAR(100) COMMENT 'Tipo de logradouro (Avenida, Rua, etc.)',
    bairro VARCHAR(100) COMMENT 'Nome do bairro',
    cidade VARCHAR(100) COMMENT 'Nome da cidade',
    estado VARCHAR(100) COMMENT 'Nome do estado',
    numero INT COMMENT 'Número do endereço'
);

-- Tabela Vendedor
CREATE TABLE vendedor (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do vendedor',
    nome VARCHAR(100) COMMENT 'Nome completo do vendedor',
    cpf VARCHAR(14) UNIQUE COMMENT 'Cadastro de Pessoa Física (CPF) do vendedor',
    cnpj VARCHAR(18) UNIQUE COMMENT 'Cadastro Nacional de Pessoa Jurídica (CNPJ), caso aplicável',
    email VARCHAR(100) UNIQUE COMMENT 'Endereço de e-mail do vendedor',
    senha VARCHAR(100) COMMENT 'Senha de acesso do vendedor',
    telefone VARCHAR(15) COMMENT 'Número de telefone do vendedor',
    dataNascimento DATE COMMENT 'Data de nascimento do vendedor',
    nacionalidade VARCHAR(50) COMMENT 'País de origem do vendedor',
    genero VARCHAR(10) COMMENT 'Gênero do vendedor',
    endereco_id INT COMMENT 'Referência ao endereço do vendedor',
    FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
);

-- Tabela Produto
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do produto',
    nome VARCHAR(100) COMMENT 'Nome do produto',
    descricao TEXT COMMENT 'Descrição detalhada do produto',
    valor DOUBLE COMMENT 'Preço unitário do produto',
    estoque INT COMMENT 'Quantidade disponível em estoque',
    vendedor_id INT COMMENT 'Referência ao vendedor do produto',
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE
);

-- Tabela Cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do cliente',
    nome VARCHAR(100) COMMENT 'Nome completo do cliente',
    cpf VARCHAR(14) UNIQUE COMMENT 'Cadastro de Pessoa Física (CPF) do cliente',
    email VARCHAR(100) UNIQUE COMMENT 'Endereço de e-mail do cliente',
    senha VARCHAR(100) COMMENT 'Senha de acesso do cliente',
    telefone VARCHAR(15) COMMENT 'Número de telefone do cliente',
    dataNascimento DATE COMMENT 'Data de nascimento do cliente',
    nacionalidade VARCHAR(50) COMMENT 'País de origem do cliente',
    genero VARCHAR(10) COMMENT 'Gênero do cliente',
    endereco_id INT COMMENT 'Referência ao endereço do cliente',
    FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
);

-- Tabela Carrinho
CREATE TABLE carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do carrinho',
    fechado BOOLEAN COMMENT 'Indica se o carrinho foi finalizado (true) ou ainda está em aberto (false)',
    precoTotal DOUBLE COMMENT 'Valor total dos itens no carrinho',
    dataPedido DATE COMMENT 'Data em que o pedido foi realizado',
    tipoPagamento INT COMMENT 'Código do tipo de pagamento escolhido',
    cliente_id INT COMMENT 'Referência ao cliente que criou o carrinho',
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Tabela Item
CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único do item',
    quantidadeItem INT COMMENT 'Quantidade do produto no carrinho',
    subTotal DOUBLE COMMENT 'Subtotal do item (quantidade x valor unitário)',
    produto_id INT COMMENT 'Referência ao produto adicionado ao carrinho',
    carrinho_id INT COMMENT 'Referência ao carrinho ao qual o item pertence',
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE SET NULL
);

-- Tabela Avaliacao
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único da avaliação',
    nota INT COMMENT 'Nota atribuída ao produto (1 a 5)',
    comentario TEXT COMMENT 'Comentário do cliente sobre o produto',
    data DATE COMMENT 'Data em que a avaliação foi realizada',
    cliente_id INT COMMENT 'Referência ao cliente que fez a avaliação',
    produto_id INT COMMENT 'Referência ao produto avaliado',
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE SET NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
);

