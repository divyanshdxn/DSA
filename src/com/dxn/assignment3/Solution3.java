package com.dxn.assignment3;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of test case:");
        n = Integer.parseInt(scanner.nextLine());
        String inp;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the string:");
            inp = scanner.nextLine();
            int l = inp.length();
            int count = 0, maxLen = 0;
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < l; j++) {
                char ch = inp.charAt(j);
                if (ch == '<') {
                    s.push(ch);
                } else {
                    if (!s.isEmpty() && s.peek() == '<') {
                        count += 2;
                        s.pop();
                    } else
                        count = 0;
                    if (count > maxLen)
                        maxLen = count;

                }
            }
            System.out.println(maxLen);
        }
    }
}
