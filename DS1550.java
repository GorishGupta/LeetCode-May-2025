public class DS1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i <= arr.length - 3; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DS1550 ds1550 = new DS1550();
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(ds1550.threeConsecutiveOdds(arr)); // Output: false
    }
}
