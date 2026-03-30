import io.Menu;
import sistema.Biblioteca;
import sistema.CadastroPessoas;
import utils.CarregadorCSV;
import utils.InputUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        CadastroPessoas cadastro = new CadastroPessoas();

        Scanner sc = new Scanner(System.in);
        InputUtils entrada = new InputUtils(sc);

        CarregadorCSV.carregarLivros("livros.csv", biblioteca);

        Menu menu = new Menu(biblioteca, cadastro, entrada, sc);
        menu.exibir();
    }
}