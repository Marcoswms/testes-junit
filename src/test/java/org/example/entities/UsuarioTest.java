package org.example.entities;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private static Usuario usuario;

    @BeforeAll
    static void criaUsuario() {
        usuario = new Usuario("Marcos", 2000.00, 10);
    }

    @AfterAll
    static void exibeMensagem() {
        System.out.println("Fim dos testes!");
    }

    @Test
    void reajusteSalarialMaior() {
        usuario.reajusteSalarial(usuario.getNota());

        assertEquals(3000.00, usuario.getSalario());
        System.out.println("Atendeu a condição");
        System.out.println(usuario.getSalario());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Olá mundo", "Amor", "Balde"})
    void validaCaracterTrue(String palavra) {
        assertTrue(usuario.validaCaracter(palavra));
    }

    @ParameterizedTest
    @ValueSource(strings = {"O    i", "  Ola  ", "E U", "Alo"})
    void validaCaracterFalse(String palavra) {
        assertFalse(usuario.validaCaracter(palavra));
    }

    @ParameterizedTest
    @CsvSource({
            "Ola mundo, true",
            "Amor, true",
            "O    i, false",
            "E U, false"
    })
    void validaCaracterTrueAndFalse(String palavra, boolean esperado) {
        assertEquals(esperado, usuario.validaCaracter(palavra));
    }

    @Test
    void capturaNullPointerException() {
        Exception erro = assertThrows(NullPointerException.class, () -> {
            usuario.validaCaracter(null);
        });
        assertEquals("Palavra não pode ser nula", erro.getMessage());
    }
}