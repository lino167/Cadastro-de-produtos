import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dB.Produtosdb;
import models.Produto;

public class Main {
    static Produtosdb produtosdb = new Produtosdb();
    public static void main(String[] args) throws Exception {
      System.out.println("--- PEDIDO DE VENDAS ---");
      
      int option;

    do{
          System.out.println("1 - Cadastrar produto");
          System.out.println("2 - Lista produtos cadastrados");
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
        }
    }
}