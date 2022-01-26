package com.dxn.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] b = {
                {1, 2, 1},
                {2, 4, 6},
                {7, 2, 5}
//                [26, 16, 28]
//                [56, 40, 64]
//                [86, 64, 100]
        };
//        int[][] a = {
//                {1, 2, 3},
//                {4, 5, 6}
//        };
//        int[][] b = {
//                {1, 1, 1,1},
//                {1, 1, 1,1},
//                {1, 1, 1,1},
////                [6, 6, 6, 6]
////                [15, 15, 15, 15]
//        };
        int[][] c = multiply(a,b);
        for(int[] arr :c){
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int m = a.length;
        int n = a[0].length;
        int r = b.length;
        int p = b[0].length;
        int[][] c = new int[m][p];
        if (n != r) {
            return new int[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }
}
