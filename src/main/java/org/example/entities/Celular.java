package org.example.entities;

import org.example.repository.VerificadorImei;

public class Celular {

    private String modelo;
    private String cor;
    private String operadora;
    private int saudeBateria;
    private String sistemaOperacional;
    private String imei;

    private VerificadorImei verificadorImei;

    public Celular(VerificadorImei verificadorImei) {
        this.verificadorImei = verificadorImei;
    }

    public String verificaIntegridadeDispositivo(String sistemaOperacional, int saudeBateria, String imei) {

        int bateriaPerfeita = 91;
        int bateriaBoa = 80;
        int bateriaReduzida = 76;

        String resultadoBateria;
        String mensagem = "Imei Limpo";
        String resultadoRestricao = verificadorImei.imeiRestrito(imei);

        if (imei == null || imei.trim().isEmpty()) {
            throw new NullPointerException("Imei não pode estar vazio!");
        }

        if (resultadoRestricao != null) {
            return resultadoRestricao;
        }

        if (saudeBateria >= bateriaPerfeita) {
            resultadoBateria = "Bateria Perfeita";
        }
        else if (saudeBateria >= bateriaBoa) {
            resultadoBateria = "Bateria Boa";
        }
        else if (saudeBateria >= bateriaReduzida) {
            resultadoBateria = "Bateria com capacidade reduzida";
        }
        else {
            resultadoBateria = "Atenção - Recomendamos a troca de bateria";
        }
        return "Bateria: " + resultadoBateria +
                "\nImei: " + mensagem;
    }
}