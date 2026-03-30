package model;

import interfaces.Emprestavel;

public class Livro extends Item implements Emprestavel {
    private boolean emprestado;

    public Livro(String titulo) {
        super(titulo);
        this.emprestado = false;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + this.getTitulo() + " | Emprestado: " + (this.emprestado ? "Sim" : "Não"));
    }

    @Override
    public void emprestar() {
        if (!this.emprestado) {
            this.emprestado = true;
            System.out.println("Livro emprestado com sucesso");
        } else {
            System.out.println("Livro já esta emprestado a alguém");
        }
    }

    @Override
    public void devolver() {
        this.emprestado = false;
        System.out.println("Livro devolvido com sucesso");
    }
}