package com.dxn.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        int[] miss = {0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(missingNumber(miss));


        List<Integer> list = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(list);

    }

    public static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == i + 1) {
                i++;
            } else {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] == n || arr[i] == i) {
                i++;
            } else {
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
        for (i = 0; i < n; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        return n;
    }


    static public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int i=0;
        while(i<nums.length ){
            if( nums[i]==i+1 || nums[nums[i]-1]==nums[i]){
                i++;
            } else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                arr.add(i+1);
            }
        }
        return arr;
    }

}
