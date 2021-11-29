package com.dxn.assignment3;

import java.util.Scanner;
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=scanner.nextLine();
        int l=str.length();
        if(str.charAt(0)=='0')
            System.out.println("NO");
        else
        {
            int t=0,flag=0;
            char ch;
            for(int i=0;i<l;i++)
            {
                ch=str.charAt(i);
                if(ch=='*')
                    t=0;
                else
                    t++;
                if(t>2)
                    flag=1;
            }
            if(flag==1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
