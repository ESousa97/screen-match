package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Calcula áreas de formas geométricas — exercício de condicionais e aritmética.
 */
public class CalculoArea {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cálculo de Áreas ===");
        System.out.println("Escolha uma forma:");
        System.out.println("1. Quadrado");
        System.out.println("2. Triângulo");
        System.out.println("3. Círculo");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.print("Lado do quadrado: ");
                double lado = scanner.nextDouble();
                double area = lado * lado;
                System.out.printf("Área do quadrado: %.2f%n", area);
            }
            case 2 -> {
                System.out.print("Base do triângulo: ");
                double base = scanner.nextDouble();
                System.out.print("Altura do triângulo: ");
                double altura = scanner.nextDouble();
                double area = (base * altura) / 2;
                System.out.printf("Área do triângulo: %.2f%n", area);
            }
            case 3 -> {
                System.out.print("Raio do círculo: ");
                double raio = scanner.nextDouble();
                double area = Math.PI * raio * raio;
                System.out.printf("Área do círculo: %.2f%n", area);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}
