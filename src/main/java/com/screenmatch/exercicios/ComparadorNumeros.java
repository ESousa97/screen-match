package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Compara dois números e exibe análises — exercício de condicionais.
 */
public class ComparadorNumeros {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Comparador de Números ===");
        System.out.print("Primeiro número: ");
        double a = scanner.nextDouble();
        System.out.print("Segundo número: ");
        double b = scanner.nextDouble();

        System.out.printf("%nNúmeros informados: %.2f e %.2f%n", a, b);

        if (a > b) {
            System.out.printf("%.2f é maior que %.2f%n", a, b);
        } else if (a < b) {
            System.out.printf("%.2f é menor que %.2f%n", a, b);
        } else {
            System.out.println("Os números são iguais.");
        }

        System.out.printf("Soma: %.2f%n", a + b);
        System.out.printf("Diferença: %.2f%n", a - b);
        System.out.printf("Produto: %.2f%n", a * b);

        if (b != 0) {
            System.out.printf("Divisão: %.2f%n", a / b);
        } else {
            System.out.println("Divisão por zero não é possível.");
        }

        System.out.printf("Média: %.2f%n", (a + b) / 2);
    }
}
