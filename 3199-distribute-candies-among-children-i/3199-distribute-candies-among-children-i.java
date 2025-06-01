class Solution {
    public int distributeCandies(int n, int limit) {
        int cnt = 0;
        for (int i = 0; i <= limit; i++) {
            int x = i;

            for (int j = 0; j <= limit; j++) {
                int y = j;

                int z = (n - x - y);

                if (z >= 0 && z <= limit)
                    cnt++;
            }
        }
        return cnt;
    }
}