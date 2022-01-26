package com.dxn.recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 4, 40, 58, 2, 84, 4};
        System.out.println(search(arr, 4));
        System.out.println(search2(arr, 4));

    }

    static int search(int[] arr, int target) {
        return linearSearch(arr, 0, target);
    }

    static ArrayList<Integer> search2(int[] arr, int target) {
        ArrayList<Integer> output = new ArrayList<>();
        linearSearch(arr, output, 0, target);
        return output;
    }

    static int linearSearch(int[] arr, int l, int target) {
        if (l == arr.length) {
            return -1;
        }
        if (arr[l] == target) {
            return l;
        } else {
            return linearSearch(arr, l + 1, target);
        }
    }

    static void linearSearch(int[] arr, ArrayList<Integer> output, int l, int target) {
        if (l == arr.length) {
            return;
        }
        if (arr[l] == target)
            output.add(l);
        linearSearch(arr, output, l + 1, target);
    }
}
