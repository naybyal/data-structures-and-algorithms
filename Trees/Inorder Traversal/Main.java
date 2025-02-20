class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    
    public static void inOrder(TreeNode root) {
        if (root == null) 
            return;
        
        inOrder(root.left);
        System.out.printf("%d\t", root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        // develop a tree 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        inOrder(root);
        System.out.println();
    }
}
