# Trem's Uai - Sistema de Gerenciamento de E-commerce

## Sobre o Projeto
O **Trem's Uai** é um sistema de gerenciamento de e-commerce desenvolvido em **Java**, com o objetivo de conectar clientes e vendedores, oferecendo funcionalidades essenciais para a comercialização de produtos. O projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos e Engenharia de Software**.

O sistema utiliza um **banco de dados local MySQL** para armazenar informações como cadastros de usuários, produtos, pedidos e histórico de compras.

## Funcionalidades

### Clientes
- Cadastro e login (email e senha).
- Gerenciamento de perfil (edição e exclusão).
- Busca de produtos.
- Adição de produtos ao carrinho.
- Visualização de carrinhos anteriores finalizados.

### Vendedores
- Cadastro e login (email e senha).
- Gerenciamento de perfil (edição e exclusão).
- Cadastro, edição e exclusão de produtos.
- Listagem de produtos cadastrados.

## Tecnologias Utilizadas
- **Java** (Linguagem principal)
- **MySQL** (Banco de Dados local)
- **JDBC** (Para conexão com o banco de dados)
- **Maven** (Gerenciamento de dependências)

## Como Executar o Projeto

### Requisitos:
- **JDK 11+** instalado
- **MySQL Server** instalado e configurado
- **Maven** instalado
- **mysql-connector-java-9+** como Librarie, disponivel em: `ecommerce/dist/lib`

### Passos:
1. Clone este repositório:
   ```bash
   git clone https://github.com/O-Ignius/Trem-s-Uai.git
   ```
2. Configure o banco de dados MySQL:
   - Execute o script SQL `BDCreate.sql`
3. Configure o arquivo `ecommerce/src/ecommerce/model/dao/ConexaoDAO.java` com suas credenciais do banco de dados.
4. Compile e execute o projeto:
   ```bash
   mvn clean install
   java -jar target/trems-uai.jar
   ```

## Contribuição
Se desejar contribuir com o projeto, siga os passos:
1. Fork o repositório.
2. Crie uma branch para sua funcionalidade (`git checkout -b minha-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona minha funcionalidade'`).
4. Envie para o repositório (`git push origin minha-feature`).
5. Abra um Pull Request.

## Licença
Este projeto é de uso acadêmico e não possui uma licença específica.

---
Desenvolvido como parte da disciplina de **Programação Orientada a Objetos e Engenharia de Software** no **IFMG**.


