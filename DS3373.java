import java.util.ArrayList;
import java.util.List;

public class DS3373 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private int[] build(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private int dfs(
            int node,
            int parent,
            int depth,
            List<List<Integer>> children,
            int[] color) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }

    public static void main(String[] args) {
        // Example usage of the DS3373 class
        // This is just a simple test to demonstrate the functionality.
        DS3373 solution = new DS3373();
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        int[][] edges2 = { { 0, 1 }, { 1, 2 } };
        int[] result = solution.maxTargetNodes(edges1, edges2);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
