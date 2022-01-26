package com.dxn.recursion;

public class Zeros {
    public static void main(String[] args) {
        System.out.println(zeros(4000,0));
    }

    static int zeros(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            return zeros(n / 10, count + 1);
        } else {
            return zeros(n / 10, count);
        }
    }
}