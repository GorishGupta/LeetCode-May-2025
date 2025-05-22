
import java.util.*;

class DS3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> assigned = new PriorityQueue<>();
        int count = 0;
        for (int time = 0, k = 0; time < nums.length; time++) {
            while (!assigned.isEmpty() && assigned.peek() < time)
                assigned.poll();
            while (k < queries.length && queries[k][0] <= time)
                available.add(queries[k++][1]);
            while (assigned.size() < nums[time]
                    && !available.isEmpty()
                    && available.peek() >= time) {
                assigned.add(available.poll());
                count++;
            }
            if (assigned.size() < nums[time])
                return -1;
        }
        return queries.length - count;
    }

    public static void main(String[] args) {
        DS3362 ds = new DS3362();
        int[] nums = { 1, 2, 3 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        System.out.println(ds.maxRemoval(nums, queries)); // Output: 0
    }
}