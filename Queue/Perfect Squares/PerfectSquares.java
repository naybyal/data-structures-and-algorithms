import java.util.*;

class PerfectSquares {
    public int numSquares(int n) {
        // Step 1: Generate all perfect squares <= n.
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        
        // Step 2: Initialize BFS.
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        
        int level = 0; // Number of perfect squares used so far.
        
        // Step 3: BFS traversal.
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;  // Increase level count for next set of subtractions.
            
            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // Try subtracting each perfect square.
                for (int square : squares) {
                    int remainder = current - square;
                    
                    // If remainder is negative, no need to check further squares.
                    if (remainder < 0) break;
                    
                    // If exactly 0, we found the answer.
                    if (remainder == 0) return level;
                    
                    // If remainder is positive and not visited, add to queue.
                    if (!visited.contains(remainder)) {
                        visited.add(remainder);
                        queue.offer(remainder);
                    }
                }
            }
        }
        
        return level;
    }
    
    // Driver code to test the solution
    public static void main(String[] args) {
        PerfectSquares sol = new PerfectSquares();
        
        int n1 = 12;
        System.out.println("Least number of perfect squares for " + n1 + " is: " + sol.numSquares(n1));
        // Expected output: 3 because 12 = 4 + 4 + 4
        
        int n2 = 13;
        System.out.println("Least number of perfect squares for " + n2 + " is: " + sol.numSquares(n2));
        // Expected output: 2 because 13 = 4 + 9
    }
}
