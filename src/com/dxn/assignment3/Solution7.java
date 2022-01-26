package com.dxn.assignment3;


import java.util.*;
public class Solution7 {
    static Stack<Integer> s1= new Stack<>();
    static Stack<Integer> s2= new Stack<>();
    static Stack<Integer> s3= new Stack<>();
    public static int popOut(Stack<Integer> s,int k,int h)
    {
        while(h>k && h>0)
        {
            h-=s.pop();
        }
        return h;
    }
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int n,h1=0,h2=0,h3=0,temp;
        for(int i=1;i<=3;i++)
        {
            System.out.print("Enter the size of stack "+i+":");
            n=kb.nextInt();
            System.out.print("Enter the elements in stack "+i+":");
            for(int j=0;j<n;j++)
            {
                if(i==1)
                {
                    temp=kb.nextInt();
                    s1.push(temp);
                    h1+=temp;
                }
                if(i==2)
                {
                    temp=kb.nextInt();
                    s2.push(temp);
                    h2+=temp;
                }
                if(i==3)
                {
                    temp=kb.nextInt();
                    s3.push(temp);
                    h3+=temp;
                }
            }
        }
        for(int i=0;;i++)
        {
            if(h1>h2 && h1>h3)
            {
                h1=popOut(s1,Math.min(h2,h3),h1);
            }
            else if(h2>h1 && h2>h3)
            {
                h2=popOut(s2,Math.min(h1,h3),h2);
            }
            else if(h3>h2 && h3>h1)
            {
                h3=popOut(s3,Math.min(h1,h2),h3);
            }
            if(h1==h2 && h2==h3 && h1==h3)
            {
                System.out.println("Maximum height: "+h1);
                break;
            }
            if(h1==0 || h2==0 || h3==0)
            {
                System.out.println("Maximum height: 0");
                break;
            }
        }
    }
}
