import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dB.Produtosdb;
import dB.UsuariosDB;
import models.Admin;
import models.Cliente;
import models.Produto;
import models.Usuario;

public class Main {
    static Produtosdb produtosdb = new Produtosdb();
    public static void main(String[] args) throws Exception {
      System.out.println("--- PEDIDO DE VENDAS ---");
      
      int option;

    do{
          System.out.println("1 - Cadastrar produto");
          System.out.println("2 - Lista produtos cadastrados");
          System.out.println("3 - Cadastrar usuário Administrador");
          System.out.println("4 - Cadastrar usuário Cliente");
          System.out.println("5 - Lista todos os usuários");
          System.out.println("0 - Sair");

          Scanner scanner = new Scanner(System.in);
          System.out.print("Qual operação você deseja realizar: ");
          option = scanner.nextInt();

          process(option);

      } while(option != 0);
      
    
    }

    public static void process(int option) throws Exception {
            switch (option) {
            case 1:{
                Scanner scanner = new Scanner(System.in);

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

                break;

            }
            case 2: {
                List<Produto> listaDeProdutos = produtosdb.getProdutosList();
                for(Produto produto : listaDeProdutos) {
                
                System.out.println("---ID: " + produto.getId());
                System.out.println("---Descrição: " + produto.getDescricao());
                System.out.println("---Preço: " + produto.getPreco());
                System.out.println("---Data de validade: " + produto.getDataValidade());
                System.out.println("------------------------------------------------------");

                }
                break;

            }

            case 3: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual o nome do usuário ADMINISTRADOR: ");
                String nome = scanner.nextLine();

                Admin novoAdmin = new Admin(nome);
                UsuariosDB.addNovoUsuario(novoAdmin);
                
                break;
            }
            case 4: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual o nome do usuário CLIENTE: ");
                String nome = scanner.nextLine();

                Cliente novoCliente = new Cliente(nome);
                UsuariosDB.addNovoUsuario(novoCliente);
               
                break;
            }
            case 5: {
                
                System.out.println("-----------------------------------------------");
                System.out.println("-------LISTAGEM DE USUÁRIOS CADASTRADOS--------");
                System.out.println("-----------------------------------------------");
                
                for(Usuario usuario : UsuariosDB.getUsuariosList()) {
                   System.out.println("ID: " + usuario.getId());
                   System.out.println("NOME: " + usuario.getNome());
                   System.out.println("TIPO: " + usuario.getTipoUsuario());
                   System.out.println("-----------------------------------------------");
                }
               
                break;
            }
        }
        
        
    }

}