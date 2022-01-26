package com.dxn.algo.binarySearch;

public class Floor {

    public static void main(String[] args) {
        int[] arr = new int[] { 2,3,5,9,14,16,18 };
        System.out.println(ceil(arr,14));
        System.out.println(ceil(arr,15));
        System.out.println(ceil(arr,17));
    }

    static int ceil(int[] arr, int x) {
        int L = 0, U = arr.length - 1 ;
        while(L<=U) {
            int M = (L + U) / 2;
            if(x>arr[M]) {
                L=M+1;
            } else if(x<arr[M]){
                U=M-1;
            } else {
                return x;
            }
        }
        return arr[U];
    }
}
