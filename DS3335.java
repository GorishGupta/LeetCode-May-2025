import java.util.*;

//
public class DS3335 {
    public int lengthAfterTransformations(String s, int t) {
        long output = 0;
        int MOD = 1_000_000_007;
        int[] charFrequency = new int[26];
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        Deque<Long> dq = new ArrayDeque<>();
        for (int i = 0; i < 26; i++)
            dq.offer(1L);
        int counter = 0;
        while (counter++ < t) {
            dq.addLast((dq.pollFirst() + dq.peekFirst()) % MOD);
        }
        for (int i = 0; i < 26; i++) {
            output += charFrequency[i] * dq.pollFirst();
            output %= MOD;
        }
        return (int) output;
    }

    public static void main(String[] args) {
        DS3335 ds3335 = new DS3335();
        String s = "abc";
        int t = 2;
        System.out.println(ds3335.lengthAfterTransformations(s, t)); // Output: 6
    }
}
