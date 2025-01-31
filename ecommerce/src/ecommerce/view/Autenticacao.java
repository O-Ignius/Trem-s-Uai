package ecommerce.view;

//Controller
import ecommerce.controller.EcommerceController;

//Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Vendedor;
import ecommerce.model.entity.Endereco;
import java.sql.Connection;

import java.util.Scanner;
import java.text.SimpleDateFormat;
                                                                    
public class Autenticacao{
    
    EcommerceController ecommerceController = new EcommerceController();
    
    public Endereco cadastroEndereco(Scanner input) {
        Endereco endereco = ecommerceController.lerEndereco(input);
        
        return endereco;
    }
    
    public void cadastroCliente(Scanner input, Connection connection) {
        Cliente cliente = ecommerceController.lerCliente(input);
        
        //set endereco
        cliente.setEndereco(ecommerceController.lerEndereco(input));
        
        //cadastro
        ecommerceController.cadastrarCliente(cliente, connection);
    }
    
    public void cadastroVendedor(Scanner input, Connection connection) {
        Vendedor vendedor = ecommerceController.lerVendedor(input);

        //set endereco
        vendedor.setEndereco(ecommerceController.lerEndereco(input));
        
        ecommerceController.cadastrarVendedor(vendedor, connection);
    }
    
    public int login(String email, String senha, Scanner input, Connection connection) {
        EcommerceController ecommerceController = new EcommerceController();
        int id;
        String tableNome = new String();
        
        //procura na tabela cliente;
        tableNome = "cliente";
        //se nao encontrar
        id = ecommerceController.login(email, senha, tableNome, connection);
        if (id < 0) {
            //procura na tabela vendedor
            tableNome = "vendedor";
            id = ecommerceController.login(email, senha, tableNome, connection);
                
            if (id < 0) {
                System.err.println("Dados incorretos!");
                return -1;
            }
            else {
                //se achar na tabela vendedor, chama menu vendedor
                ecommerceController.vendedorMenu(id, input, connection);
            }
        }
        else {
            //se achar na tabela cliente, chama menu cliente
            ecommerceController.clienteMenu(id, input, connection);
        }
        
        return 0;
    }
}