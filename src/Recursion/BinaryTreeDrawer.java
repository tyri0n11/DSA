package Recursion;

import java.util.Arrays;

public class BinaryTreeDrawer {
    private char[][] treeArray;
    private int lineLength;

    public BinaryTreeDrawer(int lineLength) {
        this.lineLength = lineLength;
        int height = (int) (Math.log(lineLength + 1) / Math.log(2));
        int width = lineLength;
        treeArray = new char[height][width];
        for (char[] row : treeArray) {
            Arrays.fill(row, '-');
        }
    }

    public void drawTree() {
        makeBranches(0, lineLength - 1, 0);
        display();
    }

    private void makeBranches(int left, int right, int row) {
        if (row >= treeArray.length) {
            return;
        }
        int mid = (left + right) / 2;
        treeArray[row][mid] = 'X';
        makeBranches(left, mid - 1, row + 1);
        makeBranches(mid + 1, right, row + 1);
    }

    private void display() {
        for (char[] row : treeArray) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        int lineLength = 32; // You can change the line length here
        BinaryTreeDrawer treeDrawer = new BinaryTreeDrawer(lineLength);
        treeDrawer.drawTree();
    }
}
