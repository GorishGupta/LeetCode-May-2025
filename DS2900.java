import java.util.ArrayList;
import java.util.List;

public class DS2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int prev = -1;

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != prev) {
                prev = groups[i];
                result.add(words[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DS2900 ds2900 = new DS2900();
        String[] words = { "apple", "banana", "cherry", "date", "elderberry" };
        int[] groups = { 1, 2, 2, 3, 3 };
        List<String> result = ds2900.getLongestSubsequence(words, groups);
        System.out.println(result); // Output: [apple, banana, cherry]
    }
}
