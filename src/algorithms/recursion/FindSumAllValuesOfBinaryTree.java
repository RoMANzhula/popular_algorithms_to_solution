package algorithms.recursion;

public class FindSumAllValuesOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sumTree(root));  // Output: 15 (the sum of all tree nodes)
    }

    public static int sumTree(TreeNode root) {
        if (root == null) return 0;

        int result = root.val + sumTree(root.left) + sumTree(root.right);

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Recursion is often used to work with trees. An example is finding the sum of all values in a binary tree.
