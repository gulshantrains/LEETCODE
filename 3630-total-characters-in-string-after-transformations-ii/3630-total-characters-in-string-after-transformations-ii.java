class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] mat = new int[26][26];

        // Build transition matrix
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                mat[(i + j) % 26][i] = (mat[(i + j) % 26][i] + 1) % MOD;
            }
        }

        // Initial frequency vector
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Exponentiate matrix
        int[][] matT = matrixPower(mat, t);

        // Multiply matrix with frequency vector
        int[] result = multiplyMatrixVector(matT, freq);

        // Sum result
        int total = 0;
        for (int x : result) {
            total = (total + x) % MOD;
        }

        return total;
    }

    // Matrix × Vector multiplication
    private int[] multiplyMatrixVector(int[][] mat, int[] vec) {
        int[] res = new int[26];
        for (int i = 0; i < 26; i++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum = (sum + 1L * mat[i][j] * vec[j]) % MOD;
            }
            res[i] = (int) sum;
        }
        return res;
    }

    // Matrix × Matrix multiplication
    private int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                long sum = 0;
                for (int k = 0; k < 26; k++) {
                    sum = (sum + 1L * A[i][k] * B[k][j]) % MOD;
                }
                res[i][j] = (int) sum;
            }
        }
        return res;
    }

    // Fast matrix exponentiation
    private int[][] matrixPower(int[][] base, int exp) {
        int[][] res = new int[26][26];

        // Initialize identity matrix
        for (int i = 0; i < 26; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }
}

/*
class Solution{
    private static int mod = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] ans = new int[26];

        for (var c : s.toCharArray()) {
            ans[c - 'a']++;
        }

        while (t-- > 0) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                if (ans[i] == 0)
                    continue;

                int size = nums.get(i); //next nums[s[i]-'a'] consecutive character

                for (int j = 1; j <= size; j++) {
                    int nextc = (i + j) % 26;
                    temp[(nextc)] = (temp[nextc] + ans[i]) % mod;
                }
            }
            ans = temp;
        }
        int a = 0;
        for (var xxx : ans) {
            a = (a + xxx) % mod;
        }
        return a;
    }
}
*/