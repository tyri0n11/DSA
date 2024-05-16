package BinarySearchTree;

public class BstChecker {

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public boolean isBst(Node root) {
        return isBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstHelper(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.value <= minValue || node.value >= maxValue) {
            return false;
        }

        // Recursively check the left and right subtrees.
        // For the left subtree, the maximum value becomes the current node's value.
        // For the right subtree, the minimum value becomes the current node's value.
        return isBstHelper(node.left, minValue, node.value) &&
                isBstHelper(node.right, node.value, maxValue);
    }

    // Additional methods can be added here if needed.

    public static void main(String[] args) {
        // Example usage:
        Node r1 = new Node(13);
        r1.left = new Node(5);
        r1.right = new Node(19);
        // ... (add other nodes as needed)

        BstChecker bstChecker = new BstChecker();
        System.out.println(bstChecker.isBst(r1) ? "Is a BST" : "Not a BST");
    }
}

