package com.screenmatch.menu;

import com.screenmatch.util.InputUtils;

import java.util.Scanner;

/**
 * Submenu de utilitários diversos.
 */
public class MenuUtilitarios {

    private final Scanner scanner;

    public MenuUtilitarios(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== UTILITÁRIOS =====");
            System.out.println("1. Conversor de temperatura");
            System.out.println("2. Calculadora de idade");
            System.out.println("3. Gerador de senhas");
            System.out.println("4. Dia da semana");
            System.out.println("0. Voltar");
            System.out.println("=======================");

            opcao = InputUtils.lerOpcaoMenu(scanner, 0, 4);

            switch (opcao) {
                case 1 -> conversorTemperatura();
                case 2 -> calculadoraIdade();
                case 3 -> geradorSenhas();
                case 4 -> diaDaSemana();
                case 0 -> System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    private void conversorTemperatura() {
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");

        int tipo = InputUtils.lerOpcaoMenu(scanner, 1, 2);
        double temp = InputUtils.lerDouble(scanner, "Temperatura: ");

        if (tipo == 1) {
            System.out.printf("%.2f°C = %.2f°F%n", temp, (temp * 9.0 / 5.0) + 32);
        } else {
            System.out.printf("%.2f°F = %.2f°C%n", temp, (temp - 32) * 5.0 / 9.0);
        }
    }

    private void calculadoraIdade() {
        int anoNascimento = InputUtils.lerInteiro(scanner, "Ano de nascimento: ");
        int anoAtual = java.time.Year.now().getValue();
        int idade = anoAtual - anoNascimento;
        System.out.printf("Idade aproximada: %d anos%n", idade);
    }

    private void geradorSenhas() {
        int tamanho = InputUtils.lerInteiro(scanner, "Tamanho da senha (8-32): ");
        if (tamanho < 8) {
            tamanho = 8;
        }
        if (tamanho > 32) {
            tamanho = 32;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        StringBuilder senha = new StringBuilder();
        java.util.Random rng = new java.util.Random();
        for (int i = 0; i < tamanho; i++) {
            senha.append(chars.charAt(rng.nextInt(chars.length())));
        }
        System.out.println("Senha gerada: " + senha);
    }

    private void diaDaSemana() {
        int dia = InputUtils.lerInteiro(scanner, "Número do dia (1=Dom, 2=Seg ... 7=Sáb): ");

        String nome = switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> "Dia inválido";
        };

        System.out.println("Dia: " + nome);
    }
}
