package dB;

import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class Produtosdb {
    private List<Produto> produtosList = new ArrayList<>();

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produto> produtosList) {
        this.produtosList = produtosList;
    }
    
    public void addNovoProduto(Produto produto){
        produtosList.add(produto);
    }
    

    
}
