package com.dxn.recursion;

public class BinarySearch {
    static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(8, 0, arr.length - 1));
    }

    static int binarySearch(int n, int l, int u) {
        int m = (l + u) / 2;
        if (l > u) {
            return -1;
        }
        if (n < arr[m]) {
            return binarySearch(n, l, m - 1);
        } else if (n > arr[m]) {
            return binarySearch(n, m + 1, u);
        } else {
            return m;
        }
    }
}
