package com.dxn.recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(1258));
        System.out.println(rev(1258));
        System.out.println(isPalindrome(1258));
        System.out.println(isPalindrome(1221));
    }

    static boolean isPalindrome(int n){
        return n==rev(n);
    }

    static int reverse(int n) {
        if (n <= 9)
            return n;
        return (n % 10) * getBase(n) + reverse(n / 10);
    }

    static int rev(int n) {
        if (n <= 9)
            return n;
        int digits = (int) Math.log10(n);
        return (n % 10) * (int) Math.pow(10, digits) + rev(n / 10);
    }

    static int getBase(int n) {
        int b = 1;
        while (n > 1) {
            b *= 10;
            n /= 10;
        }
        return b;
    }
}
