class DS1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, res = Integer.MAX_VALUE;
        int[] face = new int[7];
        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i])
                face[bottoms[i]]++;
        }
        for (int x = 1; x <= 6; x++) {
            if (face[x] < n)
                continue;
            int maintainTop = 0, maintainBottom = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (tops[i] != x)
                    maintainTop++;
                if (bottoms[i] != x)
                    maintainBottom++;
            }
            if (possible)
                res = Math.min(res, Math.min(maintainTop, maintainBottom));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] tops = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms = { 5, 2, 6, 2, 3, 2 };
        DS1007 ds = new DS1007();
        int result = ds.minDominoRotations(tops, bottoms);
        System.out.println(result); // Output: 2
    }
}