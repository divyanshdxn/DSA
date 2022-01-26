package com.dxn.tree.bst;

class BST {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int data) {
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

    public void delete(int data) {
        deleteNode(root, data);
    }

    public static Node getMinimumNode(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public int countLeaf() {
        return countLeaf(root);
    }

    public void insertRecursively(int data) {
        root = insertRecursively(root, data);
    }

    public void displayInorder() {
        printInOrder(root);
    }

    public void displayPreorder() {
        printPreOrder(root);
    }

    public void displayPostorder() {
        printPostOrder(root);
    }

    private Node insertRecursively(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (root.data > data) {
                root.left = insertRecursively(root.left, data);
            } else {
                root.right = insertRecursively(root.right, data);
            }
        }
        return root;
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    private Node deleteNode(Node root, int data) {
        Node parent = null;
        Node curr = root;
        while (curr != null && curr.data != data) {
            parent = curr;
            if (data < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return root;
        }
        if (curr.left == null && curr.right == null) {
            if (curr != root) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null;
            }
        } else if (curr.left != null && curr.right != null) {
            Node successor = getMinimumNode(curr.right);
            int val = successor.data;
            deleteNode(root, successor.data);
            curr.data = val;
        } else {
            Node child = (curr.left != null) ? curr.left : curr.right;
            if (curr != root) {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }
        return root;
    }

    private static int countLeaf(Node node) {
        if(node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else {
            return countLeaf(node.left) + countLeaf(node.right);
        }
    }
}
