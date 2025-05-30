import java.util.Arrays;

public class DS2359 {
    private void dfs(int current, int distance, int[] edges, int[] distances) {
        while (current != -1 && distances[current] == -1) {
            distances[current] = distance++;
            current = edges[current];
        }
    }

    public int closestMeetingNode(int[] edges, int start1, int start2) {
        int res = -1, Min_Of_Max = Integer.MAX_VALUE, n = edges.length;
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dfs(start1, 0, edges, dist1);
        dfs(start2, 0, edges, dist2);
        for (int i = 0; i < n; i++) {
            if (dist1[i] >= 0 && dist2[i] >= 0) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < Min_Of_Max) {
                    Min_Of_Max = maxDist;
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DS2359 solution = new DS2359();
        int[] edges = { 2, 2, 3, -1, 4, 5, 6, -1 };
        int start1 = 0;
        int start2 = 1;
        int result = solution.closestMeetingNode(edges, start1, start2);
        System.out.println("Closest meeting node: " + result); // Output the result
    }
}