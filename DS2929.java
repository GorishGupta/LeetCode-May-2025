public class DS2929 {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i <= 2 * limit)
                res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        DS2929 solution = new DS2929();
        int n = 10; // Total candies
        int limit = 3; // Maximum candies per person
        long result = solution.distributeCandies(n, limit);
        System.out.println("Total ways to distribute candies: " + result);

    }
}
