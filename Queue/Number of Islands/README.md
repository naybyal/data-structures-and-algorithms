# Number of Islands (BFS Java Solution)

This repository contains a Java implementation for the **Number of Islands** problem using **Breadth-First Search (BFS)** and a queue.

## Problem Statement

Given a 2D grid map of `'1's` (land) and `'0's` (water), the goal is to count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

For example, given the grid:

```
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1
```

The output should be **3** since there are three distinct islands.

## Approach

This solution uses **BFS** with a queue to explore the grid:

1. **Iterate Through the Grid:** For each cell in the grid, if the cell contains `'1'` (land), it is part of a new island. Increment the island count.

2. **BFS Traversal:**
   - Mark the discovered land cell as visited (by changing its value from `'1'` to `'0'`).
   - Enqueue the cell's coordinates.
   - While the queue is not empty, dequeue a cell and check its four neighbors (up, down, left, right). For each neighbor that is land (`'1'`), mark it as visited and enqueue it.

3. **Continue the Process:** Repeat until all cells are processed.

## Code Explanation

- **`numIslands` Method:** Iterates over the grid and starts a BFS for each unvisited land cell.
- **`bfs` Method:** Uses a queue to explore and mark all connected land cells as visited.
- **Time Complexity:** O(M × N) where M and N are the grid's dimensions.
- **Space Complexity:** O(min(M, N)) in the worst-case scenario.

## Visual Explanation

- Imagine the grid as a map of land and water.
- When a land cell is found, it is visited and all its adjacent land cells are explored using BFS.
- This ripple effect continues until the entire island is covered.

