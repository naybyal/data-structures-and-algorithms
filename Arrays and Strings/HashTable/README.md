It's Friday the 13th, and I have decided to seriously explore data structures and algorithms, starting today. I am not driven by the desire to get placed in big tech but rather, I am on a pursuit to become a better developer who can understand the internals of  operating systems, databases and everything low-level.

I have decided to tackle arrays and strings first, using Java as the programming language. This will not be basic, as I already know the fundamentals of arrays and strings. This time, I want to take things up a notch by solving more problems to deepen my understanding and improve my implementation of concepts like StringBuilder, HashMap, and others.

 Well, I would like to start with hash tables. 
 
 Whenever we need a data structure to store key-value pairs for extremely efficient lookups, the first thing that comes to my mind is a hash map.

"Wait a minute, Nabiel. You said you were going to start with hash tables!"

Allow me to explain. From what I've understood, HashTable and HashMap in Java differ in the following ways:

1. HashTable is synchronized, which makes it better suited for multithreaded applications.

'What do you mean by "synchronized?"'

By 'synchronized', I mean that multiple threads can access and modify the data structure simultaneously without causing data corruption.

2. HashTable does not allow null keys or null values, whereas HashMap allows one null key and multiple null values.

Now, back to why I wrote 'HashMap' instead of 'HashTable'. When you first start programming in Java, the code you write is typically non-concurrent (single-threaded). Also, HashMap was introduced after Java 1.2, and since I program in Java 17, I’m so accustomed to using HashMap over HashTable that I don't always consider the performance implications or the distinct differences between the two data structures.

Alright, let's get back to Hash Tables!
"Wait a minute, Nabiel. You said you were going to start with hash tables!"

Allow me to explain. From what I've understood, HashTable and HashMap in Java differ in the following ways:

1. HashTable is synchronized, which makes it better suited for multithreaded applications.

'What do you mean by "synchronized?"'

By 'synchronized', I mean that multip
Even though there are a number of ways to implement a hash table. The simplest implementation is to use an array of linked lists and a hash code function. 

To insert a key-value pair to the hash table, we do the following:

Compute the hash code for the key

    The key could be an int or long (both are number types in Java).
    It's important to note that different keys can have the same hash code. This happens because, while there are many possible keys, the number of hash codes is limited (we use int values for hash codes).

Map the hash code to an index in the array

    To do this, we can use a formula like hash(key) % array_length to get the index where the key-value pair should be stored.
    Two different keys could end up mapping to the same index, which is called a collision.

Store the key-value pair at that index

    At this index, we use a linked list to store key-value pairs. This helps handle collisions, where either two keys have the same hash code or two different hash codes map to the same index.
    By using a linked list, we can add new key-value pairs to the same index without losing the previous ones.

A good implementation of hash table that keeps the collision to a minimum has a lookup time of O(1). In the worst case scenario, i.e, the number of collision is very high, the lookup time is O(N), where N is the number of keys.

The alternate method to implement a hash table is to implement it as a balanced binary search tree, where the lookup time will be O(log N). 

Advantage of Balanced Binary Search Tree Implementation:
    - less space usage as we no longer allocate a large array.
    - we can iterate through the keys in order as well (can be useful at times.)



 References

 StackOverflow
 Official Java Documentation
 Cracking the Coding Interview