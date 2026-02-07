package com.screenmatch.exercicios;

/**
 * Exercício de verificação de polaridade (positivo, negativo, zero).
 */
public class Polaridade {

    public static void executar() {
        System.out.println("=== Verificação de Polaridade ===");

        int[] numeros = {42, -7, 0, 15, -3, 100, -50};

        for (int numero : numeros) {
            if (numero > 0) {
                System.out.printf("%4d → Positivo%n", numero);
            } else if (numero < 0) {
                System.out.printf("%4d → Negativo%n", numero);
            } else {
                System.out.printf("%4d → Zero%n", numero);
            }
        }

        // Contagem
        long positivos = 0;
        long negativos = 0;
        long zeros = 0;

        for (int n : numeros) {
            if (n > 0) {
                positivos++;
            } else if (n < 0) {
                negativos++;
            } else {
                zeros++;
            }
        }

        System.out.printf("%nResumo: %d positivos, %d negativos, %d zeros%n",
                positivos, negativos, zeros);
    }
}
