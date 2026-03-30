package model;

public abstract class Item {
    private final String titulo;
    private final String autor;
    private final String id;
    private final int ano;

    public Item(String titulo, String autor, String id, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.ano = ano;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getId() {
        return this.id;
    }

    public int getAno() {
        return this.ano;
    }

    public abstract void exibirInfo();
}