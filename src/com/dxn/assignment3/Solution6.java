package com.dxn.assignment3;


import java.util.*;
import java.util.Stack;

public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int n;
        System.out.println("Enter the number of test cases: ");
        n = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < n; j++) {
            System.out.println("Enter string: ");
            str = scanner.nextLine();
            int l = str.length();
            Stack<Character> s = new Stack<>();
            int t = 0;
            for (int i = 0; i < l; i++) {
                char ch = str.charAt(i);
                if (ch == '{' || ch == '[' || ch == '(') {
                    s.push(ch);
                } else {
                    if (s.empty() == true) {
                        t = 1;
                        break;
                    } else if (ch == ']' && s.peek() == '[')
                        s.pop();
                    else if (ch == '}' && s.peek() == '{')
                        s.pop();
                    else if (ch == ')' && s.peek() == '(')
                        s.pop();
                    else {
                        t = 1;
                        break;
                    }
                }
            }
            if (t == 0 && s.empty())
                System.out.println("Output: YES");
            else
                System.out.println("Output: NO");
        }
    }
}
