public class DS1920 {
    public int[] builtArray(int nums[]) {
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[nums[i]];
        }
        return temp;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 2, 1, 5, 3, 4 };
        DS1920 ds = new DS1920();
        int result[] = ds.builtArray(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
