// 5. Crie um programa que solicite ao usuário a entrada de um número inteiro. Verifique se o número é par ou ímpar e exiba uma mensagem correspondente.

import java.util.Scanner;

public class VerificadorParImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            // Solicitar número ao usuário
            System.out.println("\n=== VERIFICADOR PAR OU ÍMPAR ===");
            System.out.print("Digite um número inteiro: ");
            int numero = scanner.nextInt();

            // Verificar se é par ou ímpar
            verificarParImpar(numero);

            // Perguntar se deseja continuar
            System.out.print("\nDeseja verificar outro número? (s/n): ");
            continuar = scanner.next().toLowerCase();

        } while (continuar.equals("s") || continuar.equals("sim"));

        System.out.println("Programa encerrado. Obrigado!");
        scanner.close();
    }

    // Metodo para verificar se um número é par ou ímpar
    public static void verificarParImpar(int numero) {
        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é PAR");
            System.out.println("   (É divisível por 2)");
        } else {
            System.out.println("O número " + numero + " é ÍMPAR");
            System.out.println("   (Não é divisível por 2)");
        }

        // Informação adicional sobre o resto da divisão
        int resto = numero % 2;
        System.out.println("   Resto da divisão por 2: " + resto);
    }
}
