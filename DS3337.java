import java.util.List;

public class DS3337 {
    private static final int MOD = (int) (1e9 + 7), CHAR_NUMBER = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        if (t == 0)
            return s.length() % MOD;

        var freq = new long[CHAR_NUMBER];
        for (var ch : s.toCharArray())
            freq[ch - 97]++;

        var m = new long[CHAR_NUMBER][CHAR_NUMBER];
        int num, i, j;
        for (i = 0; i < CHAR_NUMBER; i++) {
            num = nums.get(i);
            for (j = 1; j <= num; j++)
                m[i][(i + j) % CHAR_NUMBER] = 1;
        }

        var mt = new long[CHAR_NUMBER][CHAR_NUMBER];
        for (i = 0; i < CHAR_NUMBER; i++)
            mt[i][i] = 1;
        var base = new long[CHAR_NUMBER][CHAR_NUMBER];
        for (i = 0; i < CHAR_NUMBER; i++)
            System.arraycopy(m[i], 0, base[i], 0, CHAR_NUMBER);
        while (t > 0) {
            if ((t & 1) == 1)
                mt = multiply(mt, base);
            base = multiply(base, base);
            t >>= 1;
        }

        var rowsum = new long[CHAR_NUMBER];
        for (i = 0; i < CHAR_NUMBER; i++)
            for (j = 0; j < CHAR_NUMBER; j++)
                rowsum[i] = (rowsum[i] + mt[i][j]) % MOD;

        long total = 0;
        for (i = 0; i < CHAR_NUMBER; i++)
            total = (total + (freq[i] * rowsum[i]) % MOD) % MOD;
        return (int) total;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        var c = new long[CHAR_NUMBER][CHAR_NUMBER];
        int i, j, k;

        for (i = 0; i < CHAR_NUMBER; i++)
            for (k = 0; k < CHAR_NUMBER; k++)
                if (a[i][k] != 0)
                    for (j = 0; j < CHAR_NUMBER; j++)
                        c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
        return c;
    }
}
