package com.dxn.tree.bst;

public class Main {
    static BST bst;

    public static void main(String[] args) {
        bst = new BST();
        solution1();
/*
*               8
*             /   \
*           3     10
*          /\       \
*         1  6      14
*            /\
*           4  7
*
* */
        solution2a();
        solution2b();
        solution2c();

        System.out.println("Number of leaf nodes: "+bst.countLeaf());
    }


    static void solution1() {
        bst.insertRecursively(8);
        bst.insertRecursively(3);
        bst.insertRecursively(10);
        bst.insertRecursively(1);
        bst.insertRecursively(6);
        bst.insertRecursively(14);
        bst.insertRecursively(4);
        bst.insertRecursively(7);

        System.out.print("Inorder:\t");
        bst.displayInorder();
        System.out.println();

        System.out.print("Preorder:\t");
        bst.displayPreorder();
        System.out.println();

        System.out.print("Postorder:\t");
        bst.displayPostorder();
        System.out.println();
    }

    static void solution2a() {
        System.out.println("Deleting 14 ---------");
        bst.delete(14);
        System.out.print("Inorder:\t");
        bst.displayInorder();
        System.out.println();
    }

    static void solution2b() {
        System.out.println("Deleting 3 ---------");
        bst.delete(3);
        System.out.print("Inorder:\t");
        bst.displayInorder();
        System.out.println();
    }

    static void solution2c() {
        System.out.println("Deleting 8 ---------");
        bst.delete(8);
        System.out.print("Inorder:\t");
        bst.displayInorder();
        System.out.println();
    }


}
