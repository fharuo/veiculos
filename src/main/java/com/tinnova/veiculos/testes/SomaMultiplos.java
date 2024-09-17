package com.tinnova.veiculos.testes;

public class SomaMultiplos {
    public static int somaMultiplos(int x) {
        int soma = 0;

        for (int i = 1; i < x; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }

        return soma;
    }
}
