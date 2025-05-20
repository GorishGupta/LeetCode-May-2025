public class DS3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += diff[i];
            if (nums[i] > cnt) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DS3355 ds3355 = new DS3355();
        int[] nums = { 1, 2, 3 };
        int[][] queries = { { 0, 1 }, { 1, 2 } };
        System.out.println(ds3355.isZeroArray(nums, queries)); // Output: false

    }
}
