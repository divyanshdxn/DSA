package com.dxn.algo;

import java.util.ArrayList;

public class CircularGame {
    public static void main(String[] args) {
//        System.out.println(Solution.findTheWinner(5, 2));
        System.out.println(isPalindrome(121));
    }

    public  static boolean isPalindrome(int n) {
        int rev = 0;
        while(n>0) {
            rev = (rev*10)+(n%10);
            n = n/10;
            System.out.println(rev);
        }
        System.out.println(n+" "+rev);
        return n==rev;
    }
}


class Solution {
    static int k = 0;

    static public int findTheWinner(int n, int k) {
        Solution.k = k;
        ArrayList<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }
        return getPlayer(players, 0);
    }



    static private int getPlayer(ArrayList<Integer> arr, int start) {
        if (arr.size() == 1) {
            return arr.get(0);
        }
        int dead = (start + (k - 1)) % arr.size();
        int a = arr.remove(dead);
        System.out.println(a);
        return getPlayer(arr, dead );

    }
}
