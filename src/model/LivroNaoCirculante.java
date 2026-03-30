package model;

public class LivroNaoCirculante extends Item {

    public LivroNaoCirculante(String titulo) {
        super(titulo);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro apenas para consulta local: " + this.getTitulo());
    }
}
