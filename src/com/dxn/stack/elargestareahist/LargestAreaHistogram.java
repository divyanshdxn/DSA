package com.dxn.stack.elargestareahist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        // code
        System.out.println(solveMe(a));
    }

    static int solveMe(int[] arr) {
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();
        int[] nsel = new int[arr.length];
        nsel[0] = 0;
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];
            while (!st.isEmpty()) {
                if (arr[st.peek()] < n) break;
                st.pop();
            }
            nsel[i] = st.isEmpty() ? i - 1 : st.peek();
            st.push(i);
        }

        Stack<Integer> s = new Stack<>();
        int[] nser = new int[arr.length];
        nser[arr.length - 1] = arr.length - 1;
        s.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            int n = arr[i];
            while (!s.isEmpty()) {
                if (arr[s.peek()] < n) break;
                s.pop();
            }
            nser[i] = s.isEmpty() ? i + 1 : s.peek();
            s.push(i);
        }

        maxArea = (nser[0] - nsel[0] - 1) * arr[0];
        for (int i = 0; i < nsel.length; i++) {
            int area = Math.abs(nser[i] - nsel[i] - 1) * arr[i];
            if (area > maxArea)
                maxArea = area;
            System.out.println("(" + nser[i] + " - " + nsel[i] + " -1 ) *" + arr[i] + " = " + area);
        }

        return maxArea;
    }
}
