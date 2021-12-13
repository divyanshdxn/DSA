package com.dxn.tree.bst;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
//        bst.insert(50);
//        bst.insert(10);
//        bst.insert(20);
//        bst.insert(40);
//        bst.insert(45);
//        bst.insert(26);

        bst.insertR(5);
        bst.insertR(4);
        bst.insertR(7);
        bst.insertR(6);
        bst.insertR(3);
        bst.insertR(10);
        bst.insertR(8);

        bst.display();
    }
}
