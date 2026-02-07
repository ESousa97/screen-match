package com.screenmatch.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("MenuCalculadora — Fatorial")
class MenuCalculadoraTest {

    @Test
    @DisplayName("fatorial de 0 deve ser 1")
    void fatorialDeZero() {
        assertEquals(1L, MenuCalculadora.calcularFatorial(0));
    }

    @Test
    @DisplayName("fatorial de 1 deve ser 1")
    void fatorialDeUm() {
        assertEquals(1L, MenuCalculadora.calcularFatorial(1));
    }

    @Test
    @DisplayName("fatorial de 5 deve ser 120")
    void fatorialDeCinco() {
        assertEquals(120L, MenuCalculadora.calcularFatorial(5));
    }

    @Test
    @DisplayName("fatorial de 10 deve ser 3628800")
    void fatorialDeDez() {
        assertEquals(3_628_800L, MenuCalculadora.calcularFatorial(10));
    }

    @Test
    @DisplayName("fatorial de 20 deve ser 2432902008176640000")
    void fatorialDeVinte() {
        assertEquals(2_432_902_008_176_640_000L, MenuCalculadora.calcularFatorial(20));
    }
}
