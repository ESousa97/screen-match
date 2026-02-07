package com.screenmatch.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Representa um filme no catálogo do Screen Match.
 */
public class Filme {

    private final String nome;
    private final int anoLancamento;
    private final String genero;
    private boolean incluidoNoPlano;
    private final List<Double> avaliacoes;
    private double nota;

    public Filme(String nome, int anoLancamento, String genero) {
        this(nome, anoLancamento, genero, false);
    }

    public Filme(String nome, int anoLancamento, String genero, boolean incluidoNoPlano) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.incluidoNoPlano = incluidoNoPlano;
        this.avaliacoes = new ArrayList<>();
        this.nota = 0.0;
    }

    /**
     * Adiciona uma avaliação (1.0 – 10.0) e recalcula a nota média.
     */
    public void adicionarAvaliacao(double avaliacao) {
        if (avaliacao < 1.0 || avaliacao > 10.0) {
            System.out.println("Avaliação inválida. Informe um valor entre 1 e 10.");
            return;
        }
        avaliacoes.add(avaliacao);
        nota = avaliacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public List<Double> getAvaliacoes() {
        return Collections.unmodifiableList(avaliacoes);
    }

    public double getNota() {
        return nota;
    }

    public int getTotalAvaliacoes() {
        return avaliacoes.size();
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-30s | %4d | %-12s | Nota: %4.1f (%d aval.) | Plano: %s",
                nome, anoLancamento, genero, nota, avaliacoes.size(),
                incluidoNoPlano ? "Sim" : "Não");
    }
}
