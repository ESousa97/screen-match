// 6. Crie um programa que solicite ao usuário um número e calcule o fatorial desse número.

import java.util.Scanner;

public class CalculaFatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            // Solicitar número ao usuário
            System.out.println("\n=== CALCULADORA DE FATORIAL ===");
            System.out.print("Digite um número inteiro não negativo: ");
            int numero = scanner.nextInt();

            // Verificar se o número é válido e calcular fatorial
            if (numero < 0) {
                System.out.println("Erro: O fatorial não é definido para números negativos!");
            } else {
                calcularFatorial(numero);
            }

            // Perguntar se deseja continuar
            System.out.print("\nDeseja calcular outro fatorial? (s/n): ");
            continuar = scanner.next().toLowerCase();

        } while (continuar.equals("s") || continuar.equals("sim"));

        System.out.println("Programa encerrado. Obrigado!");
        scanner.close();
    }

    // Metodo para calcular e exibir o fatorial (versão iterativa)
    public static void calcularFatorial(int numero) {
        long fatorial = 1;

        System.out.println("\n--- CÁLCULO DO FATORIAL DE " + numero + " ---");

        // Caso especial: 0! = 1
        if (numero == 0) {
            System.out.println("0! = 1 (por definição)");
            System.out.println("Resultado: " + fatorial);
            return;
        }

        // Mostrar o processo de cálculo
        System.out.print(numero + "! = ");
        for (int i = numero; i >= 1; i--) {
            System.out.print(i);
            if (i > 1) {
                System.out.print(" × ");
            }
            fatorial *= i;
        }

        System.out.println("\nResultado: " + numero + "! = " + fatorial);

        // Verificar se o resultado é muito grande
        if (fatorial < 0) {
            System.out.println("  Atenção: O resultado excedeu o limite do tipo long!");
            System.out.println("   Para números maiores, considere usar BigInteger.");
        }
    }
}
