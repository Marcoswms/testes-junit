package org.example.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void criaUsuario() {
        System.out.println("Este método será chamado antes de cada teste.");
        usuario = new Usuario("Marcos", 2000.00, 10);
    }

    @AfterEach
    void mensagens() {
        System.out.println("Este método será chamado após cada teste, mas se houver mais testes, @BeforeEach" +
                " será chamado após este, pois ele é o 1º método executado.");
    }

    @Test
    void reajusteSalarialMaior() {
        usuario.reajusteSalarial(usuario.getNota());

        assertEquals(3000.00, usuario.getSalario());
        System.out.println("Atendeu a condição");
        System.out.println(usuario.getSalario());
    }
}