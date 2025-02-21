import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        // Early exit if starting point or target is invalid
        if (deadSet.contains("0000") || deadSet.contains(target)) return -1;
        
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        startSet.add("0000");
        endSet.add(target);
        visited.add("0000");
        visited.add(target);
        
        int moves = 0;
        
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            
            Set<String> nextSet = new HashSet<>();
            for (String curr : startSet) {
                // Generate all possible next states from curr
                for (String next : getNextStates(curr)) {
                    if (deadSet.contains(next) || visited.contains(next))
                        continue;
                    if (endSet.contains(next)) {
                        return moves + 1;
                    }
                    nextSet.add(next);
                    visited.add(next);
                }
            }
            startSet = nextSet;
            moves++;
        }
        
        return -1;
    }
    
    // Helper method to generate all next states from a given combination
    private List<String> getNextStates(String s) {
        List<String> nextStates = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            // Move up (forward)
            arr[i] = original == '9' ? '0' : (char)(original + 1);
            nextStates.add(new String(arr));
            // Move down (backward)
            arr[i] = original == '0' ? '9' : (char)(original - 1);
            nextStates.add(new String(arr));
            // Restore the original digit for the next iteration
            arr[i] = original;
        }
        return nextStates;
    }
    
    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int result = sol.openLock(deadends, target);
        System.out.println("Minimum moves to open the lock: " + result);
    }
}
