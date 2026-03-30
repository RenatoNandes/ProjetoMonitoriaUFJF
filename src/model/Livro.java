package model;

import interfaces.Emprestavel;

public class Livro extends Item implements Emprestavel {
    protected int quantidade;

    public Livro(String titulo, String autor, String id, int ano, int quantidade) {
        super(titulo, autor, id, ano);
        this.quantidade = quantidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + getTitulo() +
                " | Autor: " + getAutor() +
                " | ID: " + getId() +
                " | Ano: " + getAno() +
                " | Disponível: " + this.quantidade);
    }

    @Override
    public boolean emprestar(Pessoa pessoa) {
        if (quantidade > 0) {
            quantidade--;
            System.out.println("Empréstimo realizado com sucesso!");
            return true;
        } else {
            System.out.println("Não há exemplares disponíveis de '" + getTitulo() + "' para empréstimo no momento");
            return false;
        }
    }

    @Override
    public void devolver() {
        quantidade++;
        System.out.println("Devolução realizada com sucesso");
    }
}