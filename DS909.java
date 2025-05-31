import java.util.*;

public class DS909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] min_rolls = new int[n * n + 1];
        Arrays.fill(min_rolls, -1);
        Queue<Integer> q = new LinkedList<>();
        min_rolls[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= 6 && x + i <= n * n; i++) {
                int t = x + i;
                int row = (t - 1) / n;
                int col = (t - 1) % n;
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                int y = (v > 0 ? v : t);
                if (y == n * n)
                    return min_rolls[x] + 1;
                if (min_rolls[y] == -1) {
                    min_rolls[y] = min_rolls[x] + 1;
                    q.offer(y);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DS909 solution = new DS909();
        int[][] board = {
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, 35, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, 14, 12, 11, 10 },
                { 6, 5, 4, 3, 2, 1 }
        };
        int result = solution.snakesAndLadders(board);
        System.out.println("Minimum number of rolls to reach the end: " + result);
    }
}