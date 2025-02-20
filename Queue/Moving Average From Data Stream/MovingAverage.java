import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> window;
    private int maxSize;
    private double sum;

    public MovingAverage(int size) {
        this.maxSize = size;
        this.window = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        window.offer(val);
        sum += val;

        // If the window exceeds the max size, remove the oldest element
        if (window.size() > maxSize) {
            sum -= window.poll();
        }

        return sum / window.size();
    }

    public static void main(String[] args) {
        // Test the MovingAverage class
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("Moving Average after adding 1: " + movingAverage.next(1)); // Output: 1.0
        System.out.println("Moving Average after adding 10: " + movingAverage.next(10)); // Output: 5.5
        System.out.println("Moving Average after adding 3: " + movingAverage.next(3)); // Output: 4.67
        System.out.println("Moving Average after adding 5: " + movingAverage.next(5)); // Output: 6.0
    }
}

