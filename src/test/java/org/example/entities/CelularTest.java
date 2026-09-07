package org.example.entities;

import org.example.repository.VerificadorImei;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CelularTest {

    @Test
    void verificaImeiProibido() {
        VerificadorImei verificadorMock = mock(VerificadorImei.class);
        when(verificadorMock.imeiRestrito("161514#01")).thenReturn("Atenção - Imei Bloqueado!");

        Celular celular = new Celular(verificadorMock);
        String esperado = "Atenção - Imei Bloqueado!";
        String resultado = celular.verificaIntegridadeDispositivo("iOS", 100, "161514#01");

        System.out.println(resultado);
        assertEquals(esperado, resultado);
    }

    @Test
    void verificaImeiLimpo() {
        VerificadorImei verificadorMock = mock(VerificadorImei.class);
        when(verificadorMock.imeiRestrito("161514#02")).thenReturn(null);

        Celular celular = new Celular(verificadorMock);
        String esperado = "Bateria: Bateria Perfeita\nImei: Imei Limpo";
        String resultado = celular.verificaIntegridadeDispositivo("iOS", 100, "161514#02");

        System.out.println(resultado);
        assertEquals(esperado, resultado);
    }
}