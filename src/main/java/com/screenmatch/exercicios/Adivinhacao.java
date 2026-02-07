package com.screenmatch.exercicios;

import java.util.Random;
import java.util.Scanner;

/**
 * Jogo de adivinhação — exercício de loops e condicionais.
 */
public class Adivinhacao {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroPensado = random.nextInt(100) + 1;
        int tentativas = 0;
        boolean acertou = false;

        System.out.println("=== Jogo de Adivinhação ===");
        System.out.println("Estou pensando em um número de 1 a 100.");

        while (!acertou) {
            System.out.print("Digite o seu palpite: ");
            int palpite = scanner.nextInt();
            tentativas++;

            if (palpite == numeroPensado) {
                acertou = true;
                System.out.printf("Parabéns! Você acertou em %d tentativa(s)!%n", tentativas);
            } else if (palpite < numeroPensado) {
                System.out.println("O número pensado é maior.");
            } else {
                System.out.println("O número pensado é menor.");
            }
        }
    }
}
