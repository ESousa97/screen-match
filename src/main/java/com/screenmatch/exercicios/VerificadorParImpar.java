package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Exercício de verificação de paridade — par ou ímpar.
 */
public class VerificadorParImpar {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Verificador Par ou Ímpar ===");
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.printf("%d é PAR%n", numero);
        } else {
            System.out.printf("%d é ÍMPAR%n", numero);
        }

        // Verificar faixa de números
        System.out.println("\nPares e ímpares de 1 a 20:");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%2d → %s%n", i, i % 2 == 0 ? "Par" : "Ímpar");
        }
    }
}
