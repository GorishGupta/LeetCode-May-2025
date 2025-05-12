import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits)
            count[d]++;

        List<Integer> result = new ArrayList<>();

        for (int i = 100; i <= 998; i += 2) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            count[a]--;
            count[b]--;
            count[c]--;

            if (count[a] >= 0 && count[b] >= 0 && count[c] >= 0) {
                result.add(i);
            }

            count[a]++;
            count[b]++;
            count[c]++;
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = { 1, 2, 3, 4, 5 };
        int[] result = solution.findEvenNumbers(digits);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}