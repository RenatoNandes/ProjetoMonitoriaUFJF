package utils;

import java.util.Scanner;

public class InputUtils {

    private final Scanner scanner;

    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerOpcao(int min, int max) {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                int valor = Integer.parseInt(str);
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Escolha entre " + min + " e " + max + ": ");
            }
        }
    }
}
