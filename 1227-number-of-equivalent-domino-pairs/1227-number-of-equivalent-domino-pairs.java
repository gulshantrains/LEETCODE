import java.util.Arrays;

class Solution {
    public int numEquivDominoPairs(int[][] d) {
        int cnt = 0;
        int n = d.length;

        // Sort each domino pair so that the smaller element comes first
        Arrays.sort(d, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Compare each pair of dominoes
        for (int i = 0; i < n; i++) {
            int a = d[i][0];
            int b = d[i][1];

            for (int j = i + 1; j < n; j++) {
                int c = d[j][0];
                int di = d[j][1];

                // Check if the two dominoes are equivalent
                if (a == c && b == di || a == di && b == c) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
