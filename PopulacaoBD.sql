-- Inserindo dados na tabela endereco
INSERT INTO endereco (cep, rua, complemento, logradouro, bairro, cidade, estado, numero) VALUES
(30140071, 'Rua A', 'Apto 101', 'Rua', 'Centro', 'Belo Horizonte', 'MG', 100),
(30140072, 'Rua B', 'Casa 2', 'Rua', 'Savassi', 'Belo Horizonte', 'MG', 200),
(30140073, 'Rua C', 'Bloco 3', 'Avenida', 'Funcionários', 'Belo Horizonte', 'MG', 300),
(30140074, 'Rua D', '', 'Rua', 'Lourdes', 'Belo Horizonte', 'MG', 400),
(30140075, 'Rua E', 'Fundos', 'Avenida', 'Pampulha', 'Belo Horizonte', 'MG', 500),
(30140076, 'Rua F', '', 'Rua', 'Floresta', 'Belo Horizonte', 'MG', 600),
(30140077, 'Rua G', 'Prédio 10', 'Avenida', 'Barro Preto', 'Belo Horizonte', 'MG', 700),
(30140078, 'Rua H', '', 'Rua', 'São Lucas', 'Belo Horizonte', 'MG', 800),
(30140079, 'Rua I', '', 'Avenida', 'Santa Efigênia', 'Belo Horizonte', 'MG', 900),
(30140080, 'Rua J', 'Apartamento 202', 'Rua', 'Cidade Nova', 'Belo Horizonte', 'MG', 1000);

-- Inserindo dados na tabela vendedor
INSERT INTO vendedor (nome, cpf, cnpj, email, senha, telefone, dataNascimento, nacionalidade, genero, endereco_id) VALUES
('Carlos Silva', '111.111.111-11', NULL, 'carlos@email.com', 'senha123', '31999990001', '1980-05-15', 'Brasileiro', 'Masculino', 1),
('Maria Santos', '222.222.222-22', NULL, 'maria@email.com', 'senha123', '31999990002', '1985-08-20', 'Brasileira', 'Feminino', 2),
('João Pereira', '333.333.333-33', NULL, 'joao@email.com', 'senha123', '31999990003', '1990-02-10', 'Brasileiro', 'Masculino', 3),
('Ana Souza', '444.444.444-44', NULL, 'ana@email.com', 'senha123', '31999990004', '1993-07-30', 'Brasileira', 'Feminino', 4),
('Lucas Fernandes', '555.555.555-55', NULL, 'lucas@email.com', 'senha123', '31999990005', '1982-12-01', 'Brasileiro', 'Masculino', 5),
('Juliana Lima', '666.666.666-66', NULL, 'juliana@email.com', 'senha123', '31999990006', '1995-11-25', 'Brasileira', 'Feminino', 6),
('Fernando Costa', '777.777.777-77', NULL, 'fernando@email.com', 'senha123', '31999990007', '1988-06-15', 'Brasileiro', 'Masculino', 7),
('Patricia Oliveira', '888.888.888-88', NULL, 'patricia@email.com', 'senha123', '31999990008', '1991-09-05', 'Brasileira', 'Feminino', 8),
('Ricardo Almeida', '999.999.999-99', NULL, 'ricardo@email.com', 'senha123', '31999990009', '1983-03-20', 'Brasileiro', 'Masculino', 9),
('Beatriz Mendes', '000.000.000-00', NULL, 'beatriz@email.com', 'senha123', '31999990010', '1997-04-10', 'Brasileira', 'Feminino', 10);

-- Inserindo dados na tabela produto
INSERT INTO produto (nome, descricao, valor, estoque, vendedor_id) VALUES
('Notebook', 'Notebook Dell 16GB RAM', 4500.00, 10, 1),
('Celular', 'Samsung Galaxy S21', 3500.00, 15, 2),
('Fone de Ouvido', 'Fone Bluetooth Sony', 300.00, 20, 3),
('Teclado Mecânico', 'Teclado RGB HyperX', 450.00, 25, 4),
('Mouse Gamer', 'Mouse Logitech G502', 280.00, 30, 5),
('Monitor 27"', 'Monitor LG 144Hz', 1200.00, 12, 6),
('Cadeira Gamer', 'Cadeira Ergonômica', 1500.00, 8, 7),
('SSD 1TB', 'SSD NVMe Samsung', 600.00, 22, 8),
('Placa de Vídeo', 'RTX 3060 Ti', 2800.00, 5, 9),
('Processador', 'Intel i7 12700K', 2300.00, 7, 10);

-- Inserindo dados na tabela cliente
INSERT INTO cliente (nome, cpf, email, senha, telefone, dataNascimento, nacionalidade, genero, endereco_id) VALUES
('Pedro Henrique', '123.456.789-00', 'pedro@email.com', 'senha123', '31999990011', '1995-01-01', 'Brasileiro', 'Masculino', 1),
('Camila Souza', '234.567.890-11', 'camila@email.com', 'senha123', '31999990012', '1992-06-15', 'Brasileira', 'Feminino', 2),
('Lucas Rocha', '345.678.901-22', 'lucasr@email.com', 'senha123', '31999990013', '1988-03-22', 'Brasileiro', 'Masculino', 3),
('Mariana Lopes', '456.789.012-33', 'mariana@email.com', 'senha123', '31999990014', '1999-07-11', 'Brasileira', 'Feminino', 4),
('João Marcos', '567.890.123-44', 'joaomarcos@email.com', 'senha123', '31999990015', '1985-09-30', 'Brasileiro', 'Masculino', 5),
('Gabriela Mendes', '678.901.234-55', 'gabriela@email.com', 'senha123', '31999990016', '1993-12-20', 'Brasileira', 'Feminino', 6),
('Diego Ferreira', '789.012.345-66', 'diego@email.com', 'senha123', '31999990017', '1991-05-25', 'Brasileiro', 'Masculino', 7),
('Carolina Dias', '890.123.456-77', 'carolina@email.com', 'senha123', '31999990018', '1987-08-18', 'Brasileira', 'Feminino', 8),
('Rodrigo Santos', '901.234.567-88', 'rodrigo@email.com', 'senha123', '31999990019', '1984-02-14', 'Brasileiro', 'Masculino', 9),
('Fernanda Lima', '012.345.678-99', 'fernanda@email.com', 'senha123', '31999990020', '1996-10-05', 'Brasileira', 'Feminino', 10);


-- Registros para a tabela Carrinho
INSERT INTO carrinho (fechado, precoTotal, dataPedido, tipoPagamento, cliente_id) VALUES
(false, 150.50, '2025-02-03', 1, 1),
(true, 300.75, '2025-02-03', 2, 2),
(false, 500.00, '2025-01-03', 1, 3),
(true, 700.25, '2025-02-03', 3, 4),
(false, 100.99, '2025-01-05', 2, 5),
(true, 250.00, '2025-01-06', 1, 6),
(false, 90.50, '2025-01-07', 3, 7),
(true, 1100.75, '2025-01-08', 1, 8),
(false, 45.25, '2025-01-09', 2, 9),
(true, 600.00, '2025-01-10', 3, 10),
(true, 400.00, '2025-01-10', 2, 2);


-- Registros para a tabela Item
INSERT INTO item (quantidadeItem, subTotal, produto_id, carrinho_id) VALUES
(7, 100.00, 1, 1),
(8, 50.50, 2, 2),
(3, 150.75, 3, 3),
(1, 250.00, 4, 4),
(4, 400.00, 5, 5),
(2, 180.50, 6, 6),
(1, 90.25, 7, 7),
(5, 600.75, 8, 8),
(3, 135.00, 9, 9),
(2, 200.00, 10, 10),
(2, 200.00, 2, 11);



-- Registros para a tabela Avaliacao
INSERT INTO avaliacao (nota, comentario, data, cliente_id, produto_id) VALUES
(5, 'Ótimo produto!', '2024-01-01', 1, 1),
(5, 'Ótimo processador!', '2024-01-01', 2, 1),
(4, 'Muito bom!', '2024-01-02', 2, 2),
(3, 'Produto razoável.', '2024-01-03', 3, 3),
(5, 'Excelente qualidade!', '2024-01-04', 4, 4),
(2, 'Poderia ser melhor.', '2024-01-05', 5, 5),
(4, 'Atendeu minhas expectativas.', '2024-01-06', 6, 6),
(3, 'Dentro do esperado.', '2024-01-07', 7, 7),
(5, 'Ótima compra!', '2024-01-08', 8, 8),
(1, 'Não gostei.', '2024-01-09', 9, 9),
(4, 'Bom custo-benefício.', '2024-01-10', 10, 10);