import java.util.*;

class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;  // Set front to 0 when queue is initially empty
        }
        rear = (rear + 1) % capacity;  // Move rear to the next position
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            // Only one element, reset to empty state
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;  // Move front to the next position
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;  // Return -1 if the queue is empty
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;  // Return -1 if the queue is empty
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));  // true
        System.out.println(obj.enQueue(2));  // true
        System.out.println(obj.enQueue(3));  // true
        System.out.println(obj.enQueue(4));  // false (queue is full)
        System.out.println(obj.Rear());      // 3
        System.out.println(obj.isFull());    // true
        System.out.println(obj.deQueue());   // true
        System.out.println(obj.enQueue(4));  // true
        System.out.println(obj.Rear());      // 4
    }
}
