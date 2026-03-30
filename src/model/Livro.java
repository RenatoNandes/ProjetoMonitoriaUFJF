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
    public void emprestar() {
        if (quantidade > 0) {
            quantidade--;
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Não há exemplares disponíveis de " + getTitulo() + " para empréstimo no momento");
        }
    }

    @Override
    public void devolver() {
        quantidade++;
        System.out.println("Devolução realizada com sucesso");
    }

    public boolean isDisponivel() {
        return quantidade > 0;
    }

    public void emprestarPara(Pessoa pessoa) {
        emprestar();
    }
}