package com.screenmatch.menu;

import com.screenmatch.util.InputUtils;

import java.util.Scanner;

/**
 * Submenu de calculadora interativa.
 */
public class MenuCalculadora {

    private final Scanner scanner;

    public MenuCalculadora(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== CALCULADORA INTERATIVA =====");
            System.out.println("1. Cálculo de áreas");
            System.out.println("2. Operações com números");
            System.out.println("3. Comparador de números");
            System.out.println("4. Tabuada");
            System.out.println("5. Fatorial");
            System.out.println("0. Voltar");
            System.out.println("==================================");

            opcao = InputUtils.lerOpcaoMenu(scanner, 0, 5);

            switch (opcao) {
                case 1 -> calculoDeAreas();
                case 2 -> operacoesComNumeros();
                case 3 -> comparadorDeNumeros();
                case 4 -> tabuada();
                case 5 -> fatorial();
                case 0 -> System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    private void calculoDeAreas() {
        System.out.println("\n--- Cálculo de Áreas ---");
        System.out.println("1. Triângulo");
        System.out.println("2. Retângulo");
        System.out.println("3. Círculo");

        int forma = InputUtils.lerOpcaoMenu(scanner, 1, 3);
        switch (forma) {
            case 1 -> {
                double base = InputUtils.lerDouble(scanner, "Base: ");
                double altura = InputUtils.lerDouble(scanner, "Altura: ");
                System.out.printf("Área do triângulo: %.2f%n", (base * altura) / 2);
            }
            case 2 -> {
                double lado1 = InputUtils.lerDouble(scanner, "Lado 1: ");
                double lado2 = InputUtils.lerDouble(scanner, "Lado 2: ");
                System.out.printf("Área do retângulo: %.2f%n", lado1 * lado2);
            }
            case 3 -> {
                double raio = InputUtils.lerDouble(scanner, "Raio: ");
                System.out.printf("Área do círculo: %.2f%n", Math.PI * raio * raio);
            }
        }
    }

    private void operacoesComNumeros() {
        double a = InputUtils.lerDouble(scanner, "Primeiro número: ");
        double b = InputUtils.lerDouble(scanner, "Segundo número: ");
        System.out.printf("Soma: %.2f%n", a + b);
        System.out.printf("Subtração: %.2f%n", a - b);
        System.out.printf("Multiplicação: %.2f%n", a * b);
        if (b != 0) {
            System.out.printf("Divisão: %.2f%n", a / b);
        } else {
            System.out.println("Divisão por zero não é possível.");
        }
    }

    private void comparadorDeNumeros() {
        double a = InputUtils.lerDouble(scanner, "Primeiro número: ");
        double b = InputUtils.lerDouble(scanner, "Segundo número: ");
        if (a > b) {
            System.out.printf("%.2f é maior que %.2f%n", a, b);
        } else if (a < b) {
            System.out.printf("%.2f é menor que %.2f%n", a, b);
        } else {
            System.out.println("Os números são iguais.");
        }
    }

    private void tabuada() {
        int numero = InputUtils.lerInteiro(scanner, "Número para tabuada: ");
        System.out.printf("%n--- Tabuada do %d ---%n", numero);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", numero, i, numero * i);
        }
    }

    private void fatorial() {
        int n = InputUtils.lerInteiro(scanner, "Número para fatorial (0-20): ");
        if (n < 0 || n > 20) {
            System.out.println("Informe um número entre 0 e 20.");
            return;
        }
        System.out.printf("%d! = %d%n", n, calcularFatorial(n));
    }

    /**
     * Calcula o fatorial de um número não-negativo.
     */
    static long calcularFatorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
