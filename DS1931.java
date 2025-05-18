public class DS1931 {
    final static int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        int limit = 3 * (1 << (m - 1));
        int[][] mat = new int[limit][limit];
        for (int mask1 = 0; mask1 < limit; mask1++) {
            for (int mask2 = 0; mask2 < limit; mask2++) {
                int pos1 = mask1 >> (m - 1);
                int pos2 = mask2 >> (m - 1);
                boolean isValid = (pos1 != pos2);
                for (int j = 0; j < m - 1 && isValid; j++) {
                    int d1 = 2 * (mask1 >> (m - 2 - j)) - 1;
                    int d2 = 2 * (mask2 >> (m - 2 - j)) - 1;
                    pos1 = (pos1 + 3 + d1) % 3;
                    pos2 = (pos2 + 3 + d2) % 3;
                    isValid &= (pos1 != pos2);
                }
                mat[mask1][mask2] = isValid ? 1 : 0;
            }
        }
        int[][] state = new int[limit][1];
        for (int i = 0; i < limit; i++) {
            state[i][0] = 1;
        }
        for (n--; n > 0; n /= 2) {
            if (n % 2 == 1) {
                state = mult(mat, state);
            }
            mat = mult(mat, mat);
        }
        int ret = 0;
        for (int i = 0; i < limit; i++) {
            ret = (ret + state[i][0]) % MOD;
        }
        return ret;
    }

    private int[][] mult(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] = (int) ((result[i][j] + (((long) A[i][k]) * B[k][j])) % MOD);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
