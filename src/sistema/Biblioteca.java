package sistema;

import model.*;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Item> itens = new ArrayList<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void listar() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.print((i + 1) + " - ");
                itens.get(i).exibirInfo();
            }
        }
    }

    public Item getItem(int posicao) {
        return itens.get(posicao - 1);
    }

    public int getItemTamanho() {
        return itens.size();
    }

    public void emprestarLivro(Pessoa pessoa, Livro livro) {
        int emprestimosAtivos = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getPessoa().equals(pessoa) && e.isAtivo()) {
                emprestimosAtivos++;
            }
        }

        if (emprestimosAtivos >= pessoa.getLimiteEmprestimos()) {
            System.out.println(pessoa.getNome() + " já atingiu o limite de empréstimos");
            return;
        }

        if (livro.emprestar(pessoa)) {
            emprestimos.add(new Emprestimo(pessoa, livro));
        }
    }

    public ArrayList<Emprestimo> getEmprestimosAtivosPorPessoa(Pessoa pessoa) {
        ArrayList<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getPessoa().equals(pessoa) && e.isAtivo()) {
                ativos.add(e);
            }
        }
        return ativos;
    }

    public void devolverLivro(Pessoa pessoa, int indiceEmprestimo) {
        ArrayList<Emprestimo> ativos = getEmprestimosAtivosPorPessoa(pessoa);
        if (ativos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo para " + pessoa.getNome());
            return;
        }
        Emprestimo emprestimo = ativos.get(indiceEmprestimo - 1);
        emprestimo.devolver();
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado");
            return;
        }
        for (Emprestimo e : emprestimos) {
            e.exibirInfo();
        }
    }
}