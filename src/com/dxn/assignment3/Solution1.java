package com.dxn.assignment3;
import java.util.*;
public class Solution1 {
    Queue<Integer> stack = new ArrayDeque<>();
    int size = 0;

    public void Push(int item) {
        stack.offer(item);
        size++;
    }

    public int Pop() {
        if (size == 0) {
            return -1;
        } else {
            int t = 1, pntr;
            while (t != size) {
                pntr = stack.poll();
                stack.offer(pntr);
                t++;
            }
            pntr = stack.poll();
            size--;
            return pntr;
        }
    }

    public void display() {
        System.out.println("All elements in stack:");
        for (int i : stack) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Solution1 stack = new Solution1();
        stack.Push(25);
        stack.Push(69);
        stack.Push(18);
        stack.display();
        int k = stack.Pop();
        System.out.println();
        if (k == -1)
            System.out.println("stack is empty");
        else
            System.out.println("Deleted element: " + k);
        stack.display();
    }
}
