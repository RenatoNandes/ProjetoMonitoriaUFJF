package model;

public class Professor extends  Pessoa {
    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }
}
