package AdvancedSorting;

import java.util.Stack;

public class Quizz_1 {
    public static boolean isBSTInOrder(int[] arr) {
        // Create a stack to hold nodes
        Stack<Integer> stack = new Stack<>();

        // Initialize current node as root
        int root = Integer.MIN_VALUE;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If we find a node who is on the right side
            // and smaller than the last popped node, return false
            if (arr[i] < root) {
                return false;
            }

            // If arr[i] is in right subtree of stack top,
            // Keep removing items smaller than arr[i]
            // and make the last removed item as new root.
            while (!stack.empty() && stack.peek() < arr[i]) {
                root = stack.peek();
                stack.pop();
            }

            // At this point either stack is empty or
            // arr[i] is smaller than root, push arr[i]
            stack.push(arr[i]);
        }
        return true;
    }

    // 1. Define a class Node

    class Node {
        int key;
        Node left, right;


        public Node(int item) {
            key = item;
            left = right = null;
        }
    }


    //2. Define a class BinarySearchTree containing a root node

    class BinarySearchTree {
        Node root;


        // Constructor
        BinarySearchTree() {
            root = null;
        }

        //3*.................................................................................
        Node misteryFunc(Node node, int key) {


            if (node == null) {
                node = new Node(key);
                return node;
            }


            if (key < node.key)
                node.left = misteryFunc(node.left, key);
            else if (key > node.key)
                node.right = misteryFunc(node.right, key);


            return node;
        }

        // 4*
        Node misteryFunc1(Node root, int key) {

            if (root == null || root.key == key)
                return root;


            if (root.key < key)
                return misteryFunc1(root.right, key);


            return misteryFunc1(root.left, key);
        }
    }


        public static void main(String[] args) {
            int[] arr = {53, 20, 6, 22, 13, 9, 90, 65, 81, 39, 37, 38, 75, 70, 76};
            System.out.println("Does the array represent the in-order traversal of a BST? " + isBSTInOrder(arr));
        }


}
