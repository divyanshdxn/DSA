package com.dxn.string;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }

    static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
