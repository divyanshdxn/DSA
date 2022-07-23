package com.dxn.stack.a;

import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some pair of brackets maybe extra/needless.
4. You are required to print true if you detect extra brackets and false otherwise.
e.g.
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
*/

public class DuplicateBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isBalanced(str));
    }

    static boolean isBalanced(String exp) {
        Stack<Character> s = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c == ')') {
                if (s.peek() == '(') {
                    return true;
                }
                while (!s.isEmpty()) {
                    if (s.pop() == '(')
                        break;
                }
            } else if (c != ' ') {
                s.push(c);
            }
        }
        return false;
    }
}
