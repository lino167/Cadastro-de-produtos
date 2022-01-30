package dB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Produto;

public class Produtosdb {
    private Map<Integer, Produto> produtosMap = new HashMap<>();

    public List<Produto> getProdutosList() {
        List<Produto> produtos = new ArrayList<>();
        for(Map.Entry<Integer, Produto> produto : produtosMap.entrySet()){
            produtos.add(produto.getValue());
        }
        return produtos;
    }

    public Produto getProdutoPorID(int id){
        return produtosMap.get(id);
    }
    
    public void addNovoProduto(Produto produto){
        produtosMap.put(produto.getId(), produto);
    }

  
    

    
}
