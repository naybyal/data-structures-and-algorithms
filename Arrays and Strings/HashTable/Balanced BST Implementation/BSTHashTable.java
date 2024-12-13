class BSTHashTable {

    // Inner class to represent a node in the binary search tree
    static class TreeNode {
        int key;
        String value;
        TreeNode left, right;

        TreeNode(int key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    // Root of the binary search tree
    private TreeNode root;

    // Constructor to initialize the BST
    public BSTHashTable() {
        root = null;
    }

    // Insert key-value pair into the BST
    public void insert(int key, String value) {
        root = insertRec(root, key, value);
    }

    // Helper method for insert, which performs the insertion recursively
    private TreeNode insertRec(TreeNode root, int key, String value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, value);
        } else { // If the key is already present, update the value
            root.value = value;
        }

        return root;
    }

    // Get value by key (search in the BST)
    public String get(int key) {
        return getRec(root, key);
    }

    // Helper method for get, which searches recursively
    private String getRec(TreeNode root, int key) {
        if (root == null) {
            return null; // Key not found
        }

        if (key < root.key) {
            return getRec(root.left, key);
        } else if (key > root.key) {
            return getRec(root.right, key);
        } else {
            return root.value; // Key found, return value
        }
    }

    // Print the BST (for debugging purposes)
    public void printTree() {
        printRec(root);
    }

    // Helper method to print the tree in order (for debugging)
    private void printRec(TreeNode root) {
        if (root != null) {
            printRec(root.left);
            System.out.println("Key: " + root.key + " Value: " + root.value);
            printRec(root.right);
        }
    }

    public static void main(String[] args) {
        BSTHashTable bstHashTable = new BSTHashTable();
        bstHashTable.insert(10, "Ten");
        bstHashTable.insert(20, "Twenty");
        bstHashTable.insert(5, "Five");

        bstHashTable.printTree();

        System.out.println("Value for key 10: " + bstHashTable.get(10));
        System.out.println("Value for key 5: " + bstHashTable.get(5));
    }
}
