import java.util.*;

public class Main {

    public int findTheCity(int n, int[][] edges, int dT) {

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1000000);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int wt = edge[2];

            dist[src][dst] = wt;
            dist[dst][src] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                }
            }
        }

        int min_city = 0, max_val = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= dT) {
                    count++;
                }
            }
            if (count <= max_val) {
                min_city = i;
                max_val = count;
            }
        }
        return min_city;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int n = 4;
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 3}, {1, 3, 4}, {2, 3, 1}};
        int dT = 4;
        int result = solution.findTheCity(n, edges, dT);
        System.out.println("The city with the minimum number of reachable cities within distance " + dT + " is: " + result);
    }
}
wr