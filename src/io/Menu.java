package io;

import model.*;
import sistema.Biblioteca;
import sistema.CadastroPessoas;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Biblioteca biblioteca;
    private final CadastroPessoas cadastro;
    private final InputUtils entrada;
    private final Scanner sc;

    public Menu(Biblioteca biblioteca, CadastroPessoas cadastro, InputUtils entrada, Scanner sc) {
        this.biblioteca = biblioteca;
        this.cadastro = cadastro;
        this.entrada = entrada;
        this.sc = sc;
    }

    public void exibir() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1 - Listar itens");
            System.out.println("2 - Cadastrar pessoa");
            System.out.println("3 - Listar pessoas");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = entrada.lerOpcao(0, 6);
            switch (opcao) {
                case 1:
                    biblioteca.listar();
                    break;
                case 2:
                    cadastrarPessoa();
                    break;
                case 3:
                    cadastro.listarPessoas();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    biblioteca.listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Encerrando Sistema...");
                    continuar = false;
            }
        }
    }

    private void cadastrarPessoa() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.println("Tipo de pessoa:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.print("Escolha uma opção: ");
        int tipo = entrada.lerOpcao(1, 2);

        Pessoa pessoa;
        if (tipo == 1) {
            pessoa = new Aluno(nome, matricula);
        } else {
            pessoa = new Professor(nome, matricula);
        }

        cadastro.adicionarPessoa(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    private void emprestarLivro() {
        if (cadastro.getPessoaTamanho() == 0) {
            System.out.println("Nenhuma pessoa cadastrada, Cadastre primeiro");
            return;
        }

        cadastro.listarPessoas();
        System.out.print("Escolha o número da pessoa: ");
        int p = entrada.lerOpcao(1, cadastro.getPessoaTamanho());
        Pessoa pessoa = cadastro.getPessoa(p);

        biblioteca.listar();
        System.out.print("Escolha o número do livro: ");
        int i = entrada.lerOpcao(1, biblioteca.getItemTamanho());
        Item item = biblioteca.getItem(i);

        if (item instanceof Livro) {
            biblioteca.emprestarLivro(pessoa, (Livro) item);
        } else {
            System.out.println("Esse item não pode ser emprestado.");
        }
    }

    private void devolverLivro() {
        if (cadastro.getPessoaTamanho() == 0) {
            System.out.println("Nenhuma pessoa cadastrada. Cadastre primeiro.");
            return;
        }

        cadastro.listarPessoas();
        System.out.print("Escolha o número da pessoa: ");
        int p = entrada.lerOpcao(1, cadastro.getPessoaTamanho());
        Pessoa pessoa = cadastro.getPessoa(p);

        ArrayList<Emprestimo> ativos = biblioteca.getEmprestimosAtivosPorPessoa(pessoa);
        if (ativos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo para " + pessoa.getNome());
            return;
        }

        for (int i = 0; i < ativos.size(); i++) {
            System.out.print((i + 1) + " - ");
            ativos.get(i).exibirInfo();
        }

        System.out.print("Escolha o número do empréstimo: ");
        int i = entrada.lerOpcao(1, ativos.size());

        biblioteca.devolverLivro(pessoa, i);
    }
}
