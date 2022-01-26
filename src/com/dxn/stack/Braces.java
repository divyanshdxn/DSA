package com.dxn.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Braces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        System.out.println(Arrays.toString(slidingWindow(arr, 4)));
    }

    static int[] slidingWindow(int[] arr, int k) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int[] max = new int[arr.length - k + 1];
        int j = 0;
        for (int i = 0; i < arr.length - k+1; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            max[i] = arr[j];
        }
        return max;
    }

    static void solve(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (st.peek() == '(') {
                    System.out.println("true");
                    return;
                }
                while (!st.isEmpty() && st.pop() != '(') {
                }
            } else {
                st.push(str.charAt(i));
            }
        }
        System.out.println("false");
    }

    static void solve2(String str) {
        Stack<Character> st = new Stack<>();
        String op = "[{(";
        String cl = ")}]";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) {
                    System.out.println(false);
                    return;
                } else if (st.peek() == '(' || st.peek() == '{' || st.peek() == '[') {
                    if (str.indexOf(st.peek()) != str.indexOf(ch)) {
                        System.out.println(false);
                    } else {
                        System.out.println(true);
                    }
                    return;
                } else {
                    st.pop();
                }
            } else {
                st.push(str.charAt(i));
            }
        }
        System.out.println("true");
    }

    public static boolean isBad(String exp) {
        Stack<Character> st = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch != ')') {
                st.push(ch);
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    return true;
                }
                while (!st.isEmpty() && st.pop() != '(') ;
            }
        }
        return false;
    }

    static boolean isBalanced(String exp) {
        Stack<Character> st = new Stack<>();
        String open = "({[";
        String close = ")}]";
        for (char ch : exp.toCharArray()) {
            if (close.contains(ch + "")) {
                if (!st.isEmpty() && st.peek() == open.charAt(close.indexOf(ch))) {
                    st.pop();
                } else {
                    return false;
                }
            } else if (open.contains(ch + "")) {
                st.push(ch);
            }
        }
        return st.empty();
    }

    static int[] nextGreatestRight(int[] arr) {
        int[] ngr = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        ngr[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ngr[i] = -1;
            } else {
                ngr[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ngr;
    }

    static int[] stockSpan(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] span = new int[arr.length];
        span[0] = 1;
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
                count++;
            }
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = count;
            }
            count = 1;
            st.push(arr[i]);
        }
        return span;
    }

    static int largestArea(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        left[0] = 0;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                left[i] = i;
            } else {
                left[i] = i - st.peek() - 1;
            }
            st.push(i);
        }
        st.clear();
        right[arr.length - 1] = 0;
        st.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                right[i] = (arr.length - 1) - i;
            } else {
                right[i] = st.peek() - i - 1;
            }
            st.push(i);
        }
        int max = (left[0] + right[0]) * arr[0];
        for (int i = 1; i < arr.length; i++) {
            int area = (left[i] + right[i] + 1) * arr[i];
            if (area > max)
                max = area;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return max;
    }

    static void maxAr(int[] a, int n) {
        int[] r = new int[n];
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        l[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                l[i] = -1;
            } else {
                l[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        st.push(a.length - 1);
        r[a.length - 1] = a.length;
        System.out.println(Arrays.toString(r));

        for (int i = a.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                r[i] = a.length;
            } else {
                r[i] = st.peek();
            }
            st.push(i);
        }


        int max = (r[0] - l[0] - 1) * a[0];
        for (int i = 1; i < a.length; i++) {
            int ar = (r[i] - l[i] - 1) * a[i];
            if (ar > max) {
                max = ar;
            }
        }
        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(r));
        System.out.println(max);
    }

}
