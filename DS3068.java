public class DS3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[] dp = { 0, Long.MIN_VALUE };
        for (int n : nums) {
            long cnt0 = dp[0] + n, cnt1 = dp[1] + n;
            int x = n ^ k;
            dp = new long[] { Math.max(cnt0, dp[1] + x),
                    Math.max(cnt1, dp[0] + x) };
        }
        return dp[0];
    }

    public static void main(String[] args) {
        DS3068 ds = new DS3068();
        int[] nums = { 1, 2, 3 };
        int k = 2;
        int[][] edges = { { 0, 1 }, { 1, 2 } };
        System.out.println(ds.maximumValueSum(nums, k, edges)); // Output: 6

    }
}
