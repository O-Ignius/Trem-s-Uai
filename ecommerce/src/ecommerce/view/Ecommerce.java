package ecommerce.view;

//controller
import ecommerce.controller.EcommerceController;

import ecommerce.view.Menus;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Venda;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.ItensVenda;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

import java.util.Scanner;

public class Ecommerce {

    public static void main(String[] args) {

        EcommerceController ecommerceController = new EcommerceController();
        
        ecommerceController.cadastroLoginMenu();
        
    }
    
}
