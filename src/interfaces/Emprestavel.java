package interfaces;

import model.Pessoa;

public interface Emprestavel {
    boolean emprestar(Pessoa pessoa);

    void devolver();
}