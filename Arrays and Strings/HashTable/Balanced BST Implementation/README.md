
# Implementing Hash Table Using a Balanced Binary Search Tree (BST)

### Introduction
In this implementation of a hash table, we use a Balanced Binary Search Tree (BST) instead of an array of linked lists. This helps in reducing space usage, and it also provides the advantage of ordered traversal of keys. With a balanced BST, the lookup time is O(log N), where N is the number of keys.

### Key Concepts
1. **Balanced BST**: A balanced binary search tree keeps its structure balanced, ensuring that each node has a left and right subtree with similar heights. This ensures efficient operations like insertion, deletion, and lookup with O(log N) time complexity in the average case.

2. **Hash Function**: The hash function maps the key to an index in the BST, just like the traditional array-based hash table.

### Algorithm for Insertion, Lookup, and Deletion

#### 1. **Insertion**:
   - Compute the hash code for the key.
   - Use the hash code to find the appropriate position in the BST.
   - Insert the key-value pair into the BST.
   - If the key already exists in the BST, update its value.

#### 2. **Lookup**:
   - Compute the hash code for the key.
   - Search the BST for the node corresponding to the key and return the value if found.

#### 3. **Deletion**:
   - Compute the hash code for the key.
   - Search for the key in the BST, and if found, delete the node.


### Explanation of the Code
1. **TreeNode Class**: Represents the nodes of the BST. Each node contains a key, a value, and pointers to its left and right children.

2. **HashTableBST Class**: This class manages the BST. It includes methods to insert key-value pairs (`insert`), get values by key (`get`), and print the tree in-order (`printTree`).

3. **Hash Function**: The hash function used here simply computes the modulus of the key with a small number (10) to map it to an index. This ensures that the keys are evenly distributed across the tree.

4. **Insertion**: The `insert` method adds key-value pairs to the BST. If the key already exists, it updates the value; otherwise, it inserts a new node.

5. **Lookup**: The `get` method looks up a value by its key in the BST. If the key is found, it returns the associated value; otherwise, it returns null.

6. **In-Order Traversal**: The `printTree` method prints the key-value pairs in ascending order of the keys using in-order traversal.

### Conclusion
This implementation of a hash table using a balanced binary search tree (BST) is more space-efficient than the array-based approach. It also provides the advantage of ordered traversal of keys. The lookup time in the average case is O(log N), where N is the number of keys. However, for very large datasets or in case of heavy collisions, this approach might not perform as well as the array-based implementation.
