So, it's the second day of learning DSA and I have decided to move on to dynamic arrays.

Arrays by definition, is a collection of elements of similar type. In languages like C and Java,
arrays have a fixed length and is defined when we create the array. Contrary to this, in languages like Python, arrays are resizeable dynamically, and are often called as lists.

In Java, when we need an array-like data structure that offers dynamic resizing, we typically use an ArrayList. An ArrayList is an array that resizes itself as neeeded while still providing O(1) access. A typical implementation is that when the arry is full, the array doubles in size and each doubling takes O(N) time. This happens so rarely that its amortized insertion time is still O(1).


But why is the amortized insertion runtime O(1)?

Suppose we have an array of size N. We can work backwards to compute how many elements we copied at 
each capacity increase. 

When we increase the array to K elements, the array was previously half that size. Therefore, we needed to copy K/2 elements. Thus the total number of copies to insert N elements is roughly N/2 + N/4 + .. + 2 + 1, and this is less than N.

If things are still not clear, then imagine this scenario. Suppose we have a kilometer long walk to the store. If we walk 0.5km, then 0.25km, and then 0.125km, and so on. We will never exceed 1km, although we will get very close to it.

Thus, inserting N elements takes O(N) work in total. Each insertion is O(1) on average, even though some insertions take O(N) time in the worst case.