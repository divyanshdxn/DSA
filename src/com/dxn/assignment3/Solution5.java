package com.dxn.assignment3;

import java.util.*;
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        ArrayList<Integer> v=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        System.out.println("Enter the sizeof array:");
        n= scanner.nextInt();
        System.out.println("Enter the element:");
        for(int i=0;i<n;i++)
        {
            int a=scanner.nextInt();
            v.add(a);
        }
        int t;
        for(int i=0; ;i++)
        {
            s.push(v.get(0));
            n=v.size();
            v.add(v.get(0));
            v.remove(0);
            t=0;
            for(int j=1;j<n;j++)
            {
                if(s.peek()<v.get(0))
                {
                    s.pop();
                    s.push(v.get(0));
                    t=1;
                }
                else
                {
                    v.add(v.get(0));
                }
                v.remove(0);
            }
            if(t==0)
            {
                System.out.println("Output: "+i);
                break;
            }
            s.clear();
        }
    }
}
