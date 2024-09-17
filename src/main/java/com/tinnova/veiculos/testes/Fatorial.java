package com.tinnova.veiculos.testes;

public class Fatorial {
    public static long calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        }

        long fatorial = 1;
        for (int i = 2; i <= numero; i++) {
            fatorial *= i;
        }

        return fatorial;
    }
}
