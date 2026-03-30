package model;

public abstract class Item {
    private String titulo;

    public Item(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    public abstract void exibirInfo();
}