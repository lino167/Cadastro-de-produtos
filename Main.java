import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dB.EstoquesDB;
import dB.Produtosdb;
import dB.UsuariosDB;
import models.Admin;
import models.Cliente;
import models.Estoque;
import models.Produto;
import models.Usuario;

public class Main {
    static Produtosdb produtosdb = new Produtosdb();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoquesDB estoquesDB = new EstoquesDB();

    public static void main(String[] args) throws Exception {
        System.out.println("--- PEDIDO DE VENDAS ---");

        int option;

        do {
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Lista produtos cadastrados");
            System.out.println("3 - Cadastrar usuário Administrador");
            System.out.println("4 - Cadastrar usuário Cliente");
            System.out.println("5 - Lista todos os usuários");
            System.out.println("6 - Cadastrar novo estoque de produto");
            System.out.println("7 - Lista todos os estoques");
            System.out.println("0 - Sair");

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Qual operação você deseja realizar: ");
                option = scanner.nextInt();
            }
            process(option);

        } while (option != 0);

    }

    public static void process(int option) throws Exception {
        switch (option) {
            case 1: {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Qual a descrição que voçê desejar dar ao novo produto: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Qual o ID que voçê desejar dar ao novo produto: ");
                    int id = scanner.nextInt();

                    System.out.print("Qual o preço: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Qual a data de validade: ");
                    String dataString = scanner.next();

                    Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                    Produto novoProduto = new Produto();
                    novoProduto.setDescricao(descricao);
                    novoProduto.setId(id);
                    novoProduto.setPreco(preco);
                    novoProduto.setDataValidade(dataValidade);

                    produtosdb.addNovoProduto(novoProduto);
                }

                break;

            }
            case 2: {
                List<Produto> listaDeProdutos = produtosdb.getProdutosList();
                for (Produto produto : listaDeProdutos) {

                    System.out.println("---ID: " + produto.getId());
                    System.out.println("---Descrição: " + produto.getDescricao());
                    System.out.println("---Preço: " + produto.getPreco());
                    System.out.println("---Data de validade: " + produto.getDataValidade());
                    System.out.println("------------------------------------------------------");

                }
                break;

            }

            case 3: {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Qual o nome do usuário ADMINISTRADOR: ");
                    String nome = scanner.nextLine();

                    Admin novoAdmin = new Admin(nome);
                    UsuariosDB.addNovoUsuario(novoAdmin);
                }

                break;
            }
            case 4: {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Qual o nome do usuário CLIENTE: ");
                    String nome = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nome);
                    UsuariosDB.addNovoUsuario(novoCliente);
                }

                break;
            }
            case 5: {

                System.out.println("-----------------------------------------------");
                System.out.println("-------LISTAGEM DE USUÁRIOS CADASTRADOS--------");
                System.out.println("-----------------------------------------------");

                for (Usuario usuario : UsuariosDB.getUsuariosList()) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("NOME: " + usuario.getNome());
                    System.out.println("TIPO: " + usuario.getTipoUsuario());
                    System.out.println("-----------------------------------------------");
                }

                break;
            }
            case 6: {
                System.out.println("----------------------------------------------");
                System.out.println("-------CADASTRANDO ESTOQUE DE PRODUTOS--------");
                System.out.println("----------------------------------------------");
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Qual o indentificador do estoque: ");
                    String id = scanner.next();

                    System.out.print("Qual o produto que será adicionado ao estoque (informe o Id): ");
                    int produtoid = scanner.nextInt();

                    Produto produto = produtosdb.getProdutoPorID(produtoid);

                    System.out.println("Produto ID: " + produto.getId());
                    System.out.println("Produto descrição: " + produto.getDescricao());
                    System.out.println("Produto validade: " + produto.getDataValidade());
                    System.out.println("-----------------------------------------------");

                    System.out.print("Qual a quantidade de produtos a ser adicionado ao estoque: ");
                    int quantidade = scanner.nextInt();

                    Estoque novoEstoque = new Estoque(id, produto, quantidade);
                    estoquesDB.addNovoEstoque(novoEstoque);
                }

                break;
            }
            case 7: {
                System.out.println("-----------------------------------------------");
                System.out.println("-------LISTAGEM DE ESTOQUES CADASTRADOS--------");
                System.out.println("-----------------------------------------------");

                for (Estoque estoque : estoquesDB.getEstoquesList()) {
                    System.out.println("ID: " + estoque.getId());
                    System.out.println("PRODUTO: " + estoque.getProduto().getDescricao());
                    System.out.println("PREÇO: " + estoque.getProduto().getPreco());
                    System.out.println("QUANTIDADE: " + estoque.getQuantidade());
                    System.out.println("-----------------------------------------------");
                }
                break;
            }
        }

    }

}