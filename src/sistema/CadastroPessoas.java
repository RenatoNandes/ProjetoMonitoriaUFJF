package sistema;

import model.Pessoa;

import java.util.ArrayList;

public class CadastroPessoas {
    private final ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void listarPessoas() {
        if (!pessoas.isEmpty()) {
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println((i + 1) + " - " + pessoas.get(i).getNome() + " (" + pessoas.get(i).getMatricula() + ")");
            }
        } else {
            System.out.println("Nenhum Pessoa Encontrada");
        }
    }

    public Pessoa getPessoa(int posicao) {
        return pessoas.get(posicao - 1);
    }

    public int getPessoaTamanho() {
        return pessoas.size();
    }
}