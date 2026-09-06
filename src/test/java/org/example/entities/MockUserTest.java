package org.example.entities;

import org.example.repository.PalavraProibidaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MockUserTest {

    static MockUser mockUser;
    static PalavraProibidaRepository repositoryMock;

    @BeforeAll
    static void criarUser() {
        mockUser = new MockUser(repositoryMock);
    }

    @ParameterizedTest
    @CsvSource({
            "Ola mundo, true",
            "Amor, true",
            "O    i, false",
            "E U, false"
    })
    void validaCaracterTrueAndFalse(String palavra, boolean esperado) {
        assertEquals(esperado, mockUser.validaCaracter(palavra));
    }

    @Test
    void capturaNullPointerException() {
        Exception erro = assertThrows(NullPointerException.class, () -> {
            mockUser.validaCaracter(null);
        });
        assertEquals("Palavra não pode ser nula", erro.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Amor"})
    void validaPalavraProibida(String palavra) {
        repositoryMock = mock (PalavraProibidaRepository.class);
        when(repositoryMock.isProibida("Amor")).thenReturn(true);

        MockUser mockUser = new MockUser(repositoryMock);
        boolean resultado = mockUser.validaCaracter(palavra);
        assertNotEquals(true, resultado);
    }
}