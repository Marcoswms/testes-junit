package org.example.entities;

import org.example.repository.PalavraProibidaRepository;

public class MockUser {

    private PalavraProibidaRepository repository;

    public MockUser(PalavraProibidaRepository repository){
        this.repository = repository;
    }

    public boolean validaCaracter(String palavra) {
        if (palavra == null) {
            throw new NullPointerException("Palavra não pode ser nula");
        }

        if (repository.isProibida(palavra)) {
            return false;
        }

        int limiteDeCaracter = 3;
        palavra = palavra.replaceAll("\\s", "");
        int qtdCaracter = palavra.length();

        return qtdCaracter > limiteDeCaracter;
    }
}