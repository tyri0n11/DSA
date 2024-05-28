package AdvancedSorting.homework;


public class BinaryTree {
    public static int findNodeLevel(TreeNode root, int targetValue, int currentLevel) {
        if (root == null) {
            return -1; // Node not found
        }
        if (root.value == targetValue) {
            return currentLevel; // Node found
        }
        // Recursively search in left and right subtrees
        int leftLevel = findNodeLevel(root.left, targetValue, currentLevel + 1);
        if (leftLevel != -1) {
            return leftLevel; // Node found in left subtree
        }
        return findNodeLevel(root.right, targetValue, currentLevel + 1);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        int targetNodeValue = 4;
        int level = findNodeLevel(root, targetNodeValue, 0);

        if (level != -1) {
            System.out.println("Level of node " + targetNodeValue + ": " + level);
        } else {
            System.out.println("Node " + targetNodeValue + " not found in the tree.");
        }
    }
}
