// 3. Crie um menu que oferece duas opções ao usuário: "1. Calcular área do quadrado" e "2. Calcular área do círculo". Solicite a escolha do usuário e realize o cálculo da área com base na opção selecionada.

import java.util.Scanner;

public class CalculoArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir Menu
            System.out.println("\n=== Calculo do Area! ===");
            System.out.println("1. Calcular área do quadrado");
            System.out.println("2. Calcular área do círculo");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularAreaQuadrado(scanner);
                    break;
                case 2:
                    calcularAreaCirculo(scanner);
                    break;
                case 0:
                    System.out.println("Programa encerrado. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();

    }

    // Metodo para calcular a área do quadrado
    public static void calcularAreaQuadrado(Scanner scanner) {
        System.out.println("\n--- Área do quadrado ---");
        System.out.println("Digite o valor do quadrado: ");
        double lado = scanner.nextDouble();

        if (lado > 0) {
                double area = lado * lado;
                System.out.println("A área do quadrado é: %.2f\n" + area);
            } else {
                System.out.println("Erro: O lado deve ser um valor positivo!");
        }
    }

    // Metodo para calcular a área do círculo
    public static void calcularAreaCirculo(Scanner scanner) {
        System.out.println("\n--- Área do círculo ---");
        System.out.println("Digite o valor do raio do círculo: ");
        double lado = scanner.nextDouble();

        if (lado > 0) {
            double area = Math.PI * lado * lado;
            System.out.println("A área do círculo é: %.2f\n" + area);
        } else {
            System.out.println("Erro: O lado deve ser um valor positivo!");
        }
    }
}