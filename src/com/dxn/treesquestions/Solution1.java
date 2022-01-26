package com.dxn.treesquestions;

class Tree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    static int rootIndex = 0;

    public static void main(String[] args) {
        rootIndex = 0;
        int[] inorder = {2,5,6,7,10,12,14,15,16};
        int[] preorder = {10,5,2,6,7,14,12,15,16};
        Node root = insert(inorder, preorder, 0, inorder.length - 1);
        printInOrder(root);

    }



    private static Node insert(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootData = preorder[rootIndex++];
        Node rootNode = new Node(rootData);
        if (start == end) {
            return rootNode;
        }
        rootNode.left = insert(inorder, preorder, start, indexOf(inorder, rootData, start, end) - 1);
        rootNode.right = insert(inorder, preorder, indexOf(inorder, rootData, start, end) + 1, end);
        return rootNode;
    }


    private static int indexOf(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }
}


