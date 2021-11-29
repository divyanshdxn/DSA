package com.dxn.assignment3;

import java.util.*;

public class Solution2 {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void reverse() {
        if (!stack.isEmpty()) {
            stack2.push(stack.pop());
            reverse();
        }
    }

    public static void display(Stack<Integer> s) {
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        stack.push(15);
        stack.push(24);
        stack.push(74);
        stack.push(44);
        stack.push(47);
        System.out.println("Original stack:");
        display(stack);
        reverse();
        System.out.println("Reversed stack:");
        display(stack2);

    }
}