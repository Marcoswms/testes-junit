package org.example.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @Test
    void soma() {
        double soma = calculadora.soma(2,2);
        assertEquals(4, soma);
    }

    @Test
    void divisao() {
        double divisao = calculadora.divisao(4,2);
        assertEquals(2, divisao);
    }

    @Test
    void verificaSePar() {
         boolean verifica = calculadora.verificaSePar(3);
         assertTrue(verifica);
    }
}