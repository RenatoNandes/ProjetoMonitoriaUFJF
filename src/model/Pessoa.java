package model;

public abstract class Pessoa {
    private final String nome;
    private final String matricula;

    public Pessoa(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public abstract int getLimiteEmprestimos();
}