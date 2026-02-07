package com.screenmatch.menu;

import com.screenmatch.model.Filme;
import com.screenmatch.util.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Menu principal da aplicação Screen Match.
 *
 * <p>Orquestra os submenus e gerencia o ciclo de vida da aplicação.</p>
 */
public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Filme> filmes = new ArrayList<>();
    private final Random random = new Random();

    /**
     * Inicializa dados de exemplo e inicia o loop principal.
     */
    public void executar() {
        inicializarFilmesExemplo();
        exibirBoasVindas();

        int opcao;
        do {
            opcao = exibirMenu();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n=== Obrigado por usar o Screen Match! Até logo! ===");
        scanner.close();
    }

    private void inicializarFilmesExemplo() {
        filmes.add(new Filme("Top Gun: Maverick", 2022, "Ação", true));
        filmes.add(new Filme("Avatar: O Caminho da Água", 2022, "Ficção Científica", true));
        filmes.add(new Filme("John Wick 4", 2023, "Ação", false));
        filmes.add(new Filme("Oppenheimer", 2023, "Drama", true));
        filmes.add(new Filme("Barbie", 2023, "Comédia", false));

        filmes.get(0).adicionarAvaliacao(8.5);
        filmes.get(0).adicionarAvaliacao(9.0);
        filmes.get(1).adicionarAvaliacao(7.8);
        filmes.get(2).adicionarAvaliacao(8.9);
    }

    private void exibirBoasVindas() {
        System.out.println("===============================================");
        System.out.println("      SCREEN MATCH - SISTEMA INTERATIVO");
        System.out.println("===============================================");
        System.out.println("Bem-vindo ao sistema de catálogo de filmes!\n");
    }

    private int exibirMenu() {
        System.out.println("\n============== MENU PRINCIPAL ==============");
        System.out.println("1. Gerenciar Filmes");
        System.out.println("2. Calculadora Interativa");
        System.out.println("3. Jogos");
        System.out.println("4. Utilitários");
        System.out.println("5. Relatórios");
        System.out.println("0. Sair");
        System.out.println("============================================");
        System.out.print("Escolha uma opção: ");

        return InputUtils.lerOpcaoMenu(scanner);
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> new MenuFilmes(scanner, filmes).executar();
            case 2 -> new MenuCalculadora(scanner).executar();
            case 3 -> new MenuJogos(scanner, filmes, random).executar();
            case 4 -> new MenuUtilitarios(scanner).executar();
            case 5 -> new MenuRelatorios(scanner, filmes).executar();
            case 0 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }
}
