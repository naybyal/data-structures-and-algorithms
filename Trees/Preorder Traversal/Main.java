//  Pre-order traversal of a tree 
class TreeNode {
  //  Tree Data Structure 
  int val;
  TreeNode left, right;
  TreeNode() {}
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
  //  Pre-order traversal of a tree
  public static void preOrder(TreeNode root) {
    if (root == null)
      return;
    
    System.out.printf("%d\t", root.val);
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    //  Creating a tree 
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    //  Pre-order traversal of a tree 
    preOrder(root);  
    System.out.println();
  }
}
