package com.dxn.recursion;

public class Increasing {
    public static void main(String[] args) {
        printInc(8);
        System.out.println();
        printDec(8);
        System.out.println();
        pdi(9);
    }

    public static void printInc(int n) {
        if (n == 0) {
            System.out.print(n + " ");
            return;
        }
        printDec(n - 1);
        System.out.print(n + " ");
    }

    public static void printDec(int n) {
        if (n == 0) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void pdi(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        pdi(n - 1);
        System.out.print(n + " ");
    }
}
