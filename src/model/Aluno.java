package model;

public class Aluno extends Pessoa {
    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}