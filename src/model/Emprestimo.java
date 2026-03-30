package model;

import java.util.Date;

public class Emprestimo {
    private Pessoa pessoa;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Pessoa pessoa, Livro livro) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = new Date();
    }

    public void devolver() {
        this.dataDevolucao = new Date();
        livro.devolver();
    }

    public void exibirInfo() {
        System.out.println("Emprestimo: " + pessoa.getNome() + " pegou '" + livro.getTitulo() +
                "' em " + dataEmprestimo + (dataDevolucao != null ? " | Devolvido em " + dataDevolucao : ""));
    }
}
