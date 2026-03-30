package model;

public class LivroProfessor extends Livro {
    public LivroProfessor(String titulo, String autor, String id, int ano, int quantidade) {
        super(titulo, autor, id.endsWith("P") ? id : id + "P", ano, quantidade);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + getTitulo() +
                " | Autor: " + getAutor() +
                " | ID: " + getId() +
                " | Ano: " + getAno() +
                " | Disponível: " + this.quantidade + " (Empréstimo exclusivo para professores)");
    }

    @Override
    public void emprestarPara(Pessoa pessoa) {
        if (pessoa instanceof Professor) {
            super.emprestar();
        } else {
            System.out.println("Este livro só pode ser emprestado para professores");
        }
    }
}