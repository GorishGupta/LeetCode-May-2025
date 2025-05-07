import java.util.Arrays;
import java.util.PriorityQueue;

public class DS3341 {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;

        int[][] minDist = new int[m][n];
        for (int[] arr : minDist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        int[][] dirs = new int[][] {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], d = curr[2];

            minDist[x][y] = d;
            // shortcut
            if (x == m - 1 && y == n - 1) {
                return d;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                int nd = Math.max(d, moveTime[nx][ny]) + 1;
                if (nd < minDist[nx][ny]) {
                    pq.offer(new int[] { nx, ny, nd });
                    minDist[nx][ny] = nd;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] moveTime = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        DS3341 ds = new DS3341();
        int result = ds.minTimeToReach(moveTime);
        System.out.println(result); // Output: 8
    }
}
