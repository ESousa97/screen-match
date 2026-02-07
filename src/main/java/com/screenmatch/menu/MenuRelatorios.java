package com.screenmatch.menu;

import com.screenmatch.model.Filme;
import com.screenmatch.util.InputUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Submenu de relatórios sobre o catálogo de filmes.
 */
public class MenuRelatorios {

    private final Scanner scanner;
    private final List<Filme> filmes;

    public MenuRelatorios(Scanner scanner, List<Filme> filmes) {
        this.scanner = scanner;
        this.filmes = filmes;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== RELATÓRIOS =====");
            System.out.println("1. Relatório completo");
            System.out.println("2. Estatísticas gerais");
            System.out.println("3. Top filmes por nota");
            System.out.println("4. Filmes por década");
            System.out.println("5. Disponibilidade no plano");
            System.out.println("0. Voltar");
            System.out.println("======================");

            opcao = InputUtils.lerOpcaoMenu(scanner, 0, 5);

            switch (opcao) {
                case 1 -> relatorioCompleto();
                case 2 -> estatisticasGerais();
                case 3 -> topFilmesPorNota();
                case 4 -> filmesPorDecada();
                case 5 -> disponibilidadeNoPlano();
                case 0 -> System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    private void relatorioCompleto() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        System.out.println("\n=== RELATÓRIO COMPLETO ===");
        System.out.printf("%-30s | %4s | %-12s | %-10s | %s%n",
                "Filme", "Ano", "Gênero", "Nota", "Plano");
        System.out.println("-".repeat(80));
        filmes.forEach(System.out::println);
        System.out.printf("%nTotal de filmes: %d%n", filmes.size());
    }

    private void estatisticasGerais() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        double mediaNotas = filmes.stream()
                .mapToDouble(Filme::getNota)
                .average().orElse(0.0);
        long comAvaliacao = filmes.stream()
                .filter(f -> f.getTotalAvaliacoes() > 0)
                .count();
        long noPlano = filmes.stream()
                .filter(Filme::isIncluidoNoPlano)
                .count();

        System.out.println("\n=== ESTATÍSTICAS GERAIS ===");
        System.out.printf("Total de filmes:       %d%n", filmes.size());
        System.out.printf("Filmes avaliados:      %d%n", comAvaliacao);
        System.out.printf("Média geral de notas:  %.1f%n", mediaNotas);
        System.out.printf("Filmes no plano:       %d%n", noPlano);
    }

    private void topFilmesPorNota() {
        int n = InputUtils.lerInteiro(scanner, "Quantos filmes no top? ");
        filmes.stream()
                .filter(f -> f.getTotalAvaliacoes() > 0)
                .sorted(Comparator.comparingDouble(Filme::getNota).reversed())
                .limit(n)
                .forEach(f -> System.out.printf("★ %s (%.1f)%n", f.getNome(), f.getNota()));
    }

    private void filmesPorDecada() {
        int decada = InputUtils.lerInteiro(scanner, "Década (ex: 2020): ");
        int inicio = decada - (decada % 10);
        int fim = inicio + 9;

        System.out.printf("%nFilmes de %d a %d:%n", inicio, fim);
        filmes.stream()
                .filter(f -> f.getAnoLancamento() >= inicio && f.getAnoLancamento() <= fim)
                .forEach(System.out::println);
    }

    private void disponibilidadeNoPlano() {
        System.out.println("\n--- Incluídos no Plano ---");
        filmes.stream().filter(Filme::isIncluidoNoPlano).forEach(System.out::println);

        System.out.println("\n--- NÃO incluídos no Plano ---");
        filmes.stream().filter(f -> !f.isIncluidoNoPlano()).forEach(System.out::println);
    }
}
