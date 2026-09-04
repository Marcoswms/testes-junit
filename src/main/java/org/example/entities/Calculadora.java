package org.example.entities;

public class Calculadora {

    private double total;

    public Calculadora() {

    }

    public double getTotal(){
        return total;
    }

    public double soma(int numero1, int numero2) {
        return this.total = numero1 + numero2;
    }

    public double divisao(int numero1, int numero2) {
        return this.total = numero1 / numero2;
    }

    public boolean verificaSePar(int numero) {
        return numero % 2 == 0;
    }

}
