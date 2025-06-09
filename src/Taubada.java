// 4. Crie um programa que solicite ao usuário um número e exiba a tabuada desse número de 1 a 10.

import java.util.Scanner;

public class Taubada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            // Solicitar o número ao usuário
            System.out.println("\n=== GERADOR DE TABUADA ===");
            System.out.print("Digite um número para ver sua tabuada: ");
            int numero = scanner.nextInt();

            // Exibir a tabuada
            exibirTabuada(numero);

            // Perguntar se deseja continuar
            System.out.print("\nDeseja gerar outra tabuada? (s/n): ");
            continuar = scanner.next().toLowerCase();

        } while (continuar.equals("s") || continuar.equals("sim"));

        System.out.println("Programa encerrado. Obrigado!");
        scanner.close();
    }

    // Método para exibir a tabuada de um número
    public static void exibirTabuada(int numero) {
        System.out.println("\n--- TABUADA DO " + numero + " ---");
        System.out.println("------------------------");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%2d x %2d = %3d\n", numero, i, resultado);
        }

        System.out.println("------------------------");
    }
}
