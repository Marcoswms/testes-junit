package org.example.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    //static - Dados 'static' existirá apenas uma cópia para todas as instâncias, ou seja, apontam para o mesmo lugar de memória.
    static Calculadora calculadora;

    //Este bloco será executado uma única vez, porém o primeiro a ser executado.
    @BeforeAll
    static void criaCalculadora() {
        calculadora = new Calculadora();
    }

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

    //Padroniza testes ao invés de repetir códigos com a mesma funcionalidade
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void verificaSePar(int numero) {
         assertTrue(calculadora.verificaSePar(numero));
    }

}