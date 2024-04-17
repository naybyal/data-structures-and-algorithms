import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private Set<Integer> column;
    private Set<Integer> posDiagonal;
    private Set<Integer> negDiagonal;
    private List<List<String>> res;
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        column = new HashSet<>();
        posDiagonal = new HashSet<>();
        negDiagonal = new HashSet<>();
        res = new ArrayList<>();
        board = new char[n][n];

        // Fill the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (column.contains(c) || posDiagonal.contains(r + c) || negDiagonal.contains(r - c)) {
                continue;
            }

            column.add(c);
            posDiagonal.add(r + c);
            negDiagonal.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n);

            column.remove(c);
            posDiagonal.remove(r + c);
            negDiagonal.remove(r - c);
            board[r][c] = '.';
        }
    }

    public static void main(String[] args) {
        Main solver = new Main();
        List<List<String>> solutions = solver.solveNQueens(8); // 8-Queens problem
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
