package model;

public class LivroNaoCirculante extends Livro {
    public LivroNaoCirculante(String titulo, String autor, String id, int ano) {
        super(titulo, autor, id.endsWith("NC") ? id : id + "NC", ano, 0);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + getTitulo() +
                " | Autor: " + getAutor() +
                " | ID: " + getId() +
                " | Ano: " + getAno() +
                " | Indisponível: Livro apenas para consulta local");
    }

    @Override
    public boolean emprestar(Pessoa pessoa) {
        System.out.println("Empréstimo negado! Este livro não pode ser emprestado, apenas consultado localmente");
        return false;
    }
}