import java.util.Arrays;

public class DS3024 {

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public static void main(String[] args) {
        DS3024 ds3024 = new DS3024();
        int[] nums = { 3, 3, 3 };
        System.out.println(ds3024.triangleType(nums)); // Output: equilateral
    }
}
