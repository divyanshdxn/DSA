package com.dxn.algo;

import java.util.ArrayList;
import java.util.HashMap;

public class Distinct {

    public static void main(String[] args) {
        int a[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        var x = countDistinct(a, a.length, k);
        System.out.println(x);
    }

    static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> out = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hmap.put(A[i], hmap.getOrDefault(A[i], 0) + 1);
        }
        out.add(hmap.size());
        for (int i = k; i < n; i++) {
            System.out.println(i);
            if (hmap.get(A[i - k]) == 1) {
                hmap.remove(A[i - k]);
            } else {
                hmap.put(A[i-k], hmap.get(A[i-k]) - 1);
            }
            hmap.put(A[i], hmap.getOrDefault(A[i], 0) + 1);
            out.add(hmap.size());
        }
        return out;
    }

}
