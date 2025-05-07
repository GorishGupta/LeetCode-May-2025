import java.util.*;

public class DS2071 {
    class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            int left = 0, right = Math.min(tasks.length, workers.length);
            Arrays.sort(tasks);
            Arrays.sort(workers);

            while (left < right) {
                int mid = (left + right + 1) / 2;
                int usedPills = 0;
                TreeMap<Integer, Integer> avail = new TreeMap<>();
                for (int i = workers.length - mid; i < workers.length; ++i)
                    avail.put(workers[i], avail.getOrDefault(workers[i], 0) + 1);

                boolean canAssign = true;
                for (int i = mid - 1; i >= 0; --i) {
                    int t = tasks[i];
                    int w = avail.lastKey();
                    if (w >= t) {
                        decrement(avail, w);
                    } else {
                        Integer key = avail.ceilingKey(t - strength);
                        if (key == null || ++usedPills > pills) {
                            canAssign = false;
                            break;
                        }
                        decrement(avail, key);
                    }
                }

                if (canAssign)
                    left = mid;
                else
                    right = mid - 1;
            }

            return left;
        }

        private void decrement(TreeMap<Integer, Integer> m, int k) {
            int c = m.get(k);
            if (c == 1)
                m.remove(k);
            else
                m.put(k, c - 1);
        }
    }

    public static void main(String[] args) {
        int[] tasks = { 3, 5, 8 };
        int[] workers = { 4, 6, 7 };
        int pills = 1;
        int strength = 2;
        DS2071 ds = new DS2071();
        Solution solution = ds.new Solution();
        int result = solution.maxTaskAssign(tasks, workers, pills, strength);
        System.out.println(result); // Output: 3
    }
}
