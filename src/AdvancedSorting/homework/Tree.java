class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    // Function to find the level of a given node
    int findLevel(TreeNode node, int val, int level) {
        if (node == null) {
            return -1;
        }
        if (node.val == val) {
            return level;
        }
        int leftLevel = findLevel(node.left, val, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return findLevel(node.right, val, level + 1);
    }

    // Function to find the parent of a given node
    TreeNode findParent(TreeNode node, int val) {
        if (node == null || (node.left == null && node.right == null)) {
            return null;
        }
        if ((node.left != null && node.left.val == val) || (node.right != null && node.right.val == val)) {
            return node;
        }
        TreeNode leftParent = findParent(node.left, val);
        if (leftParent != null) {
            return leftParent;
        }
        return findParent(node.right, val);
    }

    // Function to check if two nodes are cousins
    boolean areCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        int levelX = findLevel(root, x, 0);
        int levelY = findLevel(root, y, 0);

        if (levelX == -1 || levelY == -1 || levelX != levelY) {
            return false;
        }

        TreeNode parentX = findParent(root, x);
        TreeNode parentY = findParent(root, y);

        return parentX != parentY;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        int node1 = 4;
        int node2 = 6;

        if (tree.areCousins(tree.root, node1, node2)) {
            System.out.println(node1 + " and " + node2 + " are cousins");
        } else {
            System.out.println(node1 + " and " + node2 + " are not cousins");
        }
    }
}
