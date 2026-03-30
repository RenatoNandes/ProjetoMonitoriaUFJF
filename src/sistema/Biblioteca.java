package sistema;

import model.Item;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void listar() {
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(i + " - ");
            itens.get(i).exibirInfo();
        }
    }

    public Item getItem(int posicao) {
        return itens.get(posicao);
    }
}
