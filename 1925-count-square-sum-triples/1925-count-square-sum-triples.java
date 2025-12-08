class Solution {
    public int countTriples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                int sumSq = i * i + j * j;

                if (sumSq > n * n)
                    continue;

                int c = (int) Math.sqrt(sumSq);

                if (c * c == sumSq)
                    ans++;
            }
        }

        return ans * 2;
    }
}