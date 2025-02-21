import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Directions: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') { // Found a new island
                    islands++;
                    grid[r][c] = '0'; // Mark as visited immediately
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];

                        for (int[] dir : directions) {
                            int newX = x + dir[0], newY = y + dir[1];

                            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') {
                                grid[newX][newY] = '0'; // Mark as visited immediately
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }

    // Driver Code
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid)); // Output: 3
    }
}

