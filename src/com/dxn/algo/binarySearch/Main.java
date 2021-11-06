package com.dxn.algo.binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};
        System.out.println(binarySearch(arr, 18));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(arr, 90));
    }

    static int binarySearch(int[] arr, int x) {
        int L = 0;
        int U = arr.length - 1;
        while (L <= U) {
            int M = (L + U) / 2;
            if (x > arr[M]) {
                L = M + 1;
            } else if (x < arr[M]) {
                U = M - 1;
            } else {
                return M;
            }
        }
        return -1;
    }
}
