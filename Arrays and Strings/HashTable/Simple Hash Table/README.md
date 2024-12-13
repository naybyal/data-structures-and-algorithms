
# HashTable Implementation in Java

## Explanation

This program demonstrates a simple **HashTable** implementation in Java. The hash table is a data structure that stores key-value pairs and uses a hash function to determine the index at which to store or retrieve the values. In case of collisions (when two different keys map to the same index), a **linked list** is used to store multiple key-value pairs at the same index.

### Key Concepts:
1. **Hash function**: Maps the key to an index in the array.
2. **Collisions**: When two keys have the same index, they are stored in a linked list.
3. **Linked list**: A data structure used to handle collisions by storing multiple key-value pairs at the same index.

### Components of the Program:
1. **KeyValuePair class**: Represents the key-value pair stored in the hash table.
2. **hash function**: Computes an index for the key using modulo operation (`key % SIZE`).
3. **Insert function**: Adds key-value pairs to the hash table. If the key already exists, it updates the value.
4. **Get function**: Retrieves the value associated with a given key.
5. **PrintTable function**: Displays the contents of the hash table for debugging or demonstration purposes.

## Algorithm

1. **Initialization**: 
   - Define the size of the hash table (array length).
   - Initialize an array of linked lists to store key-value pairs.

2. **Hash Function**: 
   - Calculate the index using the hash function `key % SIZE`.

3. **Insert Operation**:
   - Use the hash function to find the index.
   - Check if the key already exists at that index:
     - If found, update the value.
     - If not found, add a new `KeyValuePair` to the linked list at that index.

4. **Get Operation**:
   - Use the hash function to find the index.
   - Traverse the linked list at the computed index and return the value if the key is found.
   - If the key doesn't exist, return `null`.

5. **Handling Collisions**:
   - Collisions are handled by storing multiple key-value pairs in a linked list at the same index.

6. **Print Table**:
   - Print the contents of the hash table, showing each index and its corresponding key-value pairs.