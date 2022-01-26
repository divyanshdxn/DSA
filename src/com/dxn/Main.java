package com.dxn;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        String srt = "finding";
        for(char ch : srt.toCharArray()) {
            hmap.merge(ch, 1, Integer::sum);
        }
        hmap.forEach( (ch,integer) -> {
            if(integer>1){
                System.out.println(ch);
            }
        } );
    }
}

class Test {
    int a;
    Test(int a) {
        this.a = a;
    }
    void print() {
        System.out.println(this.a);
    }

    public static void main(String[] args) {
        Test t1 = new Test(5);

    }
}
