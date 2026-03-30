package utils;

import sistema.Biblioteca;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CarregadorCSV {
    public static void carregarLivros(String caminho, Biblioteca biblioteca) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String tipo = dados[0];
                String titulo = dados[1];
                String autor = dados[2];
                String id = dados[3];
                int ano = Integer.parseInt(dados[4]);
                int quantidade = Integer.parseInt(dados[5]);

                switch (tipo) {
                    case "normal" -> biblioteca.adicionar(new Livro(titulo, autor, id, ano, quantidade));
                    case "naoCirculante" -> biblioteca.adicionar(new LivroNaoCirculante(titulo, autor, id, ano));
                    case "professor" -> biblioteca.adicionar(new LivroProfessor(titulo, autor, id, ano, quantidade));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar CSV: " + e.getMessage());
        }
    }
}
