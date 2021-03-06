package dB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Estoque;

public class EstoquesDB {
    private static Map<String, Estoque> estoquesDBMap = new HashMap<>();

    public List<Estoque> getEstoquesList() {
        List<Estoque> estoques = new ArrayList<>();
        for (Map.Entry<String, Estoque> estoque : estoquesDBMap.entrySet()) {
            estoques.add(estoque.getValue());
        }
        return estoques;
    }

    public Map<String, Estoque> getEstoquesDBMap() {
        return estoquesDBMap;
    }

    public void addNovoEstoque(Estoque estoque) {
        estoquesDBMap.put(estoque.getId(), estoque);
    }

}
