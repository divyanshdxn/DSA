package com.dxn.stack.gmergeoverlapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlapping {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> st = new Stack<>();
        st.push(arr[0]);
        Arrays.stream(arr).forEach(pair -> {
            if ((st.peek()[1] - pair[0]) >= -1) {
                int[] p = st.pop();
                st.push(new int[]{p[0], Math.max(p[1], pair[1])});
            } else {
                st.push(pair);
            }
        });
        st.forEach(ints -> System.out.println(ints[0] + " " + ints[1]));
    }
}
