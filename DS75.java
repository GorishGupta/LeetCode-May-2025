public abstract class DS75 {
    public void sortColors(int[] nums) {
        // bubble sort
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        DS75 ds75 = new DS75() {
        };
        int[] nums = { 3, 2, 1, 0 };
        ds75.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
