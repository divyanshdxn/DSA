package com.dxn.stack.fslidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SlidingWindow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        // code
        var ans = solveMe(a, 4);
        System.out.println(Arrays.toString(ans));
    }

    static int[] solveMe(int[] arr, int p) {
        int[] ans = new int[arr.length - p];
        int[] nge = nger(arr);
        for (int i = 0; i < arr.length - p; i++) {
            int k = i;
            while (nge[k] < i + p) {
                k = nge[k];
            }
            ans[i] = arr[k];
        }
        return ans;
    }


    static int[] nger(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = Integer.MAX_VALUE;
        for (int i = arr.length - 2; i >= 0; i--) {
            int n = arr[i];
            while (!st.isEmpty()) {
                if (arr[st.peek()] > n) break;
                st.pop();
            }
            nge[i] = st.isEmpty() ? Integer.MAX_VALUE : st.peek();
            st.push(i);
        }
        return nge;
    }
}
