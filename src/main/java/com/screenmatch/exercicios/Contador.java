package com.screenmatch.exercicios;

/**
 * Exercício de contagem — demonstra loop for com incremento correto.
 */
public class Contador {

    public static void executar() {
        System.out.println("=== Exercício de Contador ===");

        System.out.println("Contagem de 1 a 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Contagem: " + i);
        }

        System.out.println("\nContagem de pares (2 a 20):");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Par: " + i);
        }

        System.out.println("\nContagem regressiva (10 a 1):");
        for (int i = 10; i >= 1; i--) {
            System.out.println("Regressiva: " + i);
        }
    }
}
