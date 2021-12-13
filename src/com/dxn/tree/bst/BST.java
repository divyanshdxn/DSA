package com.dxn.tree.bst;

public class BST {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node pointer = root;
            Node parent = pointer;
            while (pointer != null) {
                parent = pointer;
                if (pointer.data < data) {
                    pointer = pointer.right;
                } else {
                    pointer = pointer.left;
                }
            }
            if (parent.data < data) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
    }


    void insertR(int data) {
        root = insertRecursively(root,data);
    }

    Node insertRecursively(Node root, int data) {
        if(root==null) {
            return new Node(data);
        } else {
            if(root.data>data) {
                root.left=insertRecursively(root.left,data);
            } else {
                root.right=insertRecursively(root.right,data);
            }
        }
        return root;
    }

    void find(int data) {
        
    }

    void display() {
        print(root);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        print(node.left);
        print(node.right);
    }
}
