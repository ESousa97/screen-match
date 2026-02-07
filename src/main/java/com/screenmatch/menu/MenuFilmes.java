package com.screenmatch.menu;

import com.screenmatch.model.Filme;
import com.screenmatch.util.InputUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Submenu de gerenciamento de filmes.
 */
public class MenuFilmes {

    private final Scanner scanner;
    private final List<Filme> filmes;

    public MenuFilmes(Scanner scanner, List<Filme> filmes) {
        this.scanner = scanner;
        this.filmes = filmes;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAR FILMES =====");
            System.out.println("1. Listar filmes");
            System.out.println("2. Adicionar filme");
            System.out.println("3. Avaliar filme");
            System.out.println("4. Buscar filme por nome");
            System.out.println("5. Filtrar por gênero");
            System.out.println("6. Alterar disponibilidade no plano");
            System.out.println("0. Voltar");
            System.out.println("============================");

            opcao = InputUtils.lerOpcaoMenu(scanner, 0, 6);

            switch (opcao) {
                case 1 -> listarFilmes();
                case 2 -> adicionarFilme();
                case 3 -> avaliarFilme();
                case 4 -> buscarFilmePorNome();
                case 5 -> filtrarPorGenero();
                case 6 -> alterarDisponibilidade();
                case 0 -> System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    private void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        System.out.println("\n--- Catálogo de Filmes ---");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.printf("[%d] %s%n", i + 1, filmes.get(i));
        }
    }

    private void adicionarFilme() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        int ano = InputUtils.lerInteiro(scanner, "Ano de lançamento: ");
        System.out.print("Gênero: ");
        String genero = scanner.nextLine().trim();
        boolean plano = InputUtils.lerSimNao(scanner, "Incluído no plano?");

        Filme filme = new Filme(nome, ano, genero, plano);
        filmes.add(filme);
        System.out.println("Filme adicionado: " + filme.getNome());
    }

    private void avaliarFilme() {
        listarFilmes();
        if (filmes.isEmpty()) {
            return;
        }
        int indice = InputUtils.lerInteiro(scanner, "Número do filme: ") - 1;
        if (indice < 0 || indice >= filmes.size()) {
            System.out.println("Filme não encontrado.");
            return;
        }
        double nota = InputUtils.lerDouble(scanner, "Nota (1 a 10): ");
        filmes.get(indice).adicionarAvaliacao(nota);
        System.out.printf("Avaliação registrada! Nova média: %.1f%n", filmes.get(indice).getNota());
    }

    private void buscarFilmePorNome() {
        System.out.print("Termo de busca: ");
        String termo = scanner.nextLine().trim().toLowerCase();
        filmes.stream()
                .filter(f -> f.getNome().toLowerCase().contains(termo))
                .forEach(System.out::println);
    }

    private void filtrarPorGenero() {
        System.out.print("Gênero: ");
        String genero = scanner.nextLine().trim().toLowerCase();
        filmes.stream()
                .filter(f -> f.getGenero().toLowerCase().contains(genero))
                .forEach(System.out::println);
    }

    private void alterarDisponibilidade() {
        listarFilmes();
        if (filmes.isEmpty()) {
            return;
        }
        int indice = InputUtils.lerInteiro(scanner, "Número do filme: ") - 1;
        if (indice < 0 || indice >= filmes.size()) {
            System.out.println("Filme não encontrado.");
            return;
        }
        Filme filme = filmes.get(indice);
        boolean novo = InputUtils.lerSimNao(scanner, "Incluir no plano?");
        filme.setIncluidoNoPlano(novo);
        System.out.println("Disponibilidade atualizada para: " + (novo ? "Sim" : "Não"));
    }
}
