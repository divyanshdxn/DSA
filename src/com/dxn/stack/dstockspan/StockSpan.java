package com.dxn.stack.dstockspan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        // solve
        return solveMe(arr);
    }

    public static int[] solveMe(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] indices = new int[arr.length];
        int[] ans = new int[arr.length];
        indices[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];
            while (!st.isEmpty()) {
                if (arr[st.peek()] > n) break;
                st.pop();
            }
            indices[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = i-indices[i];
        }
        return ans;
    }

}
