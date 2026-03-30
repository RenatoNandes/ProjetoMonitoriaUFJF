package model;

import java.util.Date;

public class Emprestimo {
    private final Pessoa pessoa;
    private final Livro livro;
    private final Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Pessoa pessoa, Livro livro) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = new Date();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isAtivo() {
        return dataDevolucao == null;
    }

    public void devolver() {
        if (isAtivo()) {
            this.dataDevolucao = new Date();
            livro.devolver();
            System.out.println("Devolução registrada com sucesso");
        } else {
            System.out.println("Este empréstimo já foi encerrado");
        }
    }

    public void exibirInfo() {
        System.out.println("Empréstimo: " + pessoa.getNome() + " pegou '" + livro.getTitulo() +
                "' em " + dataEmprestimo + (dataDevolucao != null ? " | Devolvido em " + dataDevolucao : " | Em aberto"));
    }
}