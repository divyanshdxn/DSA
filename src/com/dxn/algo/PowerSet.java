package com.dxn.algo;

import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
//        powerSet("abc",0,"");
        permutations("abc",0,2);
    }
    static void powerSet(String s, int i, String curr ){
        if(i==s.length()) {
            System.out.print(curr+" ");
            return;
        }
        powerSet(s,i+1,curr+s.charAt(i));
        powerSet(s,i+1,curr);
    }
   static void permutations(String s, int l, int r) {
        if(l==r) {
            System.out.println(s);
            return;
        }
        for(int i=l;i<=r;i++) {
            s = swap(s,l,i);
            permutations(s,l+1,r);
            s = swap(s,l,i);
        }
    }

    private static String swap(String s, int l, int i) {
        char[] str = s.toCharArray();
        char tmp = str[l];
        str[l]=str[i];
        str[i]=tmp;
        return String.copyValueOf(str);
    }
}
