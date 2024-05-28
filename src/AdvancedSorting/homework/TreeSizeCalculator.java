package AdvancedSorting.homework;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class TreeSizeCalculator {
    public static int treeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Recursively calculate the size of the left and right subtrees
        int leftSize = treeSize(root.left);
        int rightSize = treeSize(root.right);
        // Add 1 for the current node
        return 1 + leftSize + rightSize;
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the size of the tree
        int sizeOfTree = treeSize(root);
        System.out.println("Size of the tree: " + sizeOfTree);
    }
}
