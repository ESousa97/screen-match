package com.screenmatch.menu;

import com.screenmatch.model.Filme;
import com.screenmatch.util.InputUtils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Submenu de jogos interativos.
 */
public class MenuJogos {

    private final Scanner scanner;
    private final List<Filme> filmes;
    private final Random random;

    public MenuJogos(Scanner scanner, List<Filme> filmes, Random random) {
        this.scanner = scanner;
        this.filmes = filmes;
        this.random = random;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== JOGOS =====");
            System.out.println("1. Jogo de Adivinhação");
            System.out.println("2. Quiz de Filmes");
            System.out.println("3. Contador Regressivo");
            System.out.println("0. Voltar");
            System.out.println("=================");

            opcao = InputUtils.lerOpcaoMenu(scanner, 0, 3);

            switch (opcao) {
                case 1 -> jogoAdivinhacao();
                case 2 -> quizDeFilmes();
                case 3 -> contadorRegressivo();
                case 0 -> System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    private void jogoAdivinhacao() {
        int secreto = random.nextInt(100) + 1;
        int tentativas = 0;
        System.out.println("\nAdivinhe o número (1-100)!");

        while (true) {
            int palpite = InputUtils.lerInteiro(scanner, "Seu palpite: ");
            tentativas++;

            if (palpite == secreto) {
                System.out.printf("Parabéns! Acertou em %d tentativa(s)!%n", tentativas);
                break;
            } else if (palpite < secreto) {
                System.out.println("Muito baixo! Tente novamente.");
            } else {
                System.out.println("Muito alto! Tente novamente.");
            }
        }
    }

    private void quizDeFilmes() {
        if (filmes.size() < 2) {
            System.out.println("Cadastre ao menos 2 filmes para jogar o quiz.");
            return;
        }
        int indice = random.nextInt(filmes.size());
        Filme filme = filmes.get(indice);

        System.out.printf("%nQual filme foi lançado em %d e é do gênero '%s'?%n",
                filme.getAnoLancamento(), filme.getGenero());
        System.out.print("Sua resposta: ");
        String resposta = scanner.nextLine().trim();

        if (resposta.equalsIgnoreCase(filme.getNome())) {
            System.out.println("Correto!");
        } else {
            System.out.println("Errado! Era: " + filme.getNome());
        }
    }

    private void contadorRegressivo() {
        int inicio = InputUtils.lerInteiro(scanner, "Iniciar contagem de: ");
        System.out.println("\nContagem regressiva:");
        for (int i = inicio; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("FIM!");
    }
}
