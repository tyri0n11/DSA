package BinarySearchTree;

public class BST <Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private int val;
        private Node left;
        private Node right;

        public Node(Key key, int val) {
            this.key = key;
            this.val = val;
        }

        private Node root;

        public void put(Key key, int val) {
            root = put(root, key, val); // Call the private helper method
        }
        private Node put(Node n, Key key, int val) {
            if (n == null) {
                return new Node(key, val);
            }
            int cmp = key.compareTo(n.key);
            if (cmp < 0) {
                n.left = put(n.left, key, val); // Recurse on the left subtree
            } else if (cmp > 0) {
                n.right = put(n.right, key, val); // Recurse on the right subtree
            } else {
                // Key already exists, update the value
                n.val = val;
            }
            return n;
        }
        int findMin(){
            return findMinHelper(root);
        }
        private int findMinHelper (Node node){
            if(node.left == null){
                return node.val;
            }return findMinHelper(node.left);
        }
        boolean isInorderTraversal(int[] arr){
            return isInorderHelper(root,arr,new int[]{0});
        }private boolean isInorderHelper(Node node, int[] arr, int[] index){
            if(node == null){
                return true;
            }
            if (!isInorderHelper(node.left, arr, index)) {
                return false;
            }

            // Compare current node's value with array element
            if (node.val != arr[index[0]]) {
                return false;
            }
            index[0]++; // Move to the next element in the array

            // Check right subtree
            return isInorderHelper(node.right, arr, index);
        }
    }
    public static void main(String[] args){
    }
}
