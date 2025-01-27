package ecommerce.view;

//Controller
import ecommerce.controller.EcommerceController;

//Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Vendedor;

public class Autenticacao {
    Menus menu = new Menus();
    Formulario formulario = new Formulario();
    
    public void cadastroCliente() {
        Cliente cliente = formulario.lerCliente();
        
        //set endereco
        cliente.setEndereco(formulario.lerEndereco());
    }
    
    public void cadastroVendedor() {
        Vendedor vendedor = formulario.lerVendedor();

        //set endereco
        vendedor.setEndereco(formulario.lerEndereco());
    }
    
    public int login(String email, String senha) {
        EcommerceController ecommerceController = new EcommerceController();
        int id;
        String tableNome = new String();
        
        //procura na tabela cliente;
        tableNome = "cliente";
        //se nao encontrar
        id = ecommerceController.login(email, senha, tableNome);
        if (id < 0) {
            //procura na tabela vendedor
            tableNome = "vendedor";
            id = ecommerceController.login(email, senha, tableNome);
                
            if (id < 0) {
                System.err.println("Dados incorretos!");
                return -1;
            }
            else {
                //se achar na tabela vendedor, chama menu vendedor
                menu.vendedor(id);
            }
        }
        else {
            //se achar na tabela cliente, chama menu cliente
            menu.cliente(id);
        }
        
        return 0;
    }
}