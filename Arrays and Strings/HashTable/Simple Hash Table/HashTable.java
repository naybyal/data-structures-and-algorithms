import java.util.LinkedList;

class HashTable {

    // Define the size of the hash table (array length)
    private static final int SIZE = 10;

    // Inner class to store key-value pairs
    static class KeyValuePair {
        int key;
        String value;

        KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of linked lists for storing key-value pairs
    private LinkedList<KeyValuePair>[] table;

    // Constructor to initialize the hash table
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to compute the index
    private int hash(int key) {
        return key % SIZE; // Simple modulo operation to get index
    }

    // Insert key-value pair into the hash table
    public void insert(int key, String value) {
        int index = hash(key);
        LinkedList<KeyValuePair> bucket = table[index];

        // Check if key already exists, and update value if found
        for (KeyValuePair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        // If key doesn't exist, add new key-value pair
        bucket.add(new KeyValuePair(key, value));
    }

    // Get value by key
    public String get(int key) {
        int index = hash(key);
        LinkedList<KeyValuePair> bucket = table[index];

        for (KeyValuePair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return null; // If key doesn't exist
    }

    // Print the hash table (for debugging purposes)
    public void printTable() {
        for (int i = 0; i < SIZE; i++) {
            if (table[i].size() > 0) {
                System.out.print("Index " + i + ": ");
                for (KeyValuePair pair : table[i]) {
                    System.out.print("[" + pair.key + " -> " + pair.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.insert(11, "Eleven");

        hashTable.printTable();

        System.out.println("Value for key 2: " + hashTable.get(2));
        System.out.println("Value for key 11: " + hashTable.get(11));
    }
}
