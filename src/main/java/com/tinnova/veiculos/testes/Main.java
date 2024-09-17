package com.tinnova.veiculos.testes;

public class Main {
    public static void main(String[] args) {

        //TESTE 01
        Eleicao eleicao = new Eleicao(1000, 800, 150, 50);
        System.out.println(eleicao.calcularPercentualBrancos() + "% de votos brancos");
        System.out.println(eleicao.calcularPercentualValidos() + "% de votos válidos");
        System.out.println(eleicao.calcularPercentualNulos() + "% de votos nulos");

        //TESTE 02
        int[] v = {5, 3, 2, 4, 7, 1, 0, 6};
        BubbleSort.bubbleSort(v);
        printArray(v);

        //TESTE 03
        System.out.println("o fatorial de 6 é: " + Fatorial.calcularFatorial(6));

        //TESTE 04
        System.out.println(SomaMultiplos.somaMultiplos(10));

    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

