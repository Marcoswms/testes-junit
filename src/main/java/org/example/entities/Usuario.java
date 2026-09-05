package org.example.entities;

public class Usuario {

    private String nome;
    private double salario;
    private int nota;

    public Usuario(String nome, double salario, int nota) {
        this.nome = nome;
        this.salario = salario;
        this.nota = nota;
    }

    public void reajusteSalarial(int nota) {
        if(nota > 8) {
            this.salario *= 1.50;
        }
        else {
            this.salario *= 1.10;
        }
    }

    public boolean contaCaracter(String palavra) {
        int limiteDeCaracter = 3;
        palavra = palavra.replaceAll("\\s", "");
        int qtdCaracter = palavra.length();

        return qtdCaracter > limiteDeCaracter;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getNota() {
        return nota;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
