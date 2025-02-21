import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private List<Integer>[] adjList; // Adjacency list

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = (List<Integer>[]) new ArrayList[vertices]; // Type-safe array creation
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>(); // Initialize adjacency lists
        }
    }

    // Add an edge from the source vertex to the destination vertex
    void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>(); 

        // Mark the start vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        // until the queue is empty, do
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex
            System.out.print(vertex + " "); 

            // Enqueue all adjacent vertices (neighbours) that haven't been visited
            for (int adjVertex : adjList[vertex]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6); 

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Breadth First Traversal starting from vertex 0:");
        graph.BFS(0);
    }
}
