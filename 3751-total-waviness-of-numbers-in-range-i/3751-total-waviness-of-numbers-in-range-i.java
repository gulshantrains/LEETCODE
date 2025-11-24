class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int i = num1; i <= num2; i++) {
            String s = String.valueOf(i);
            int n = s.length();

            if (n < 3)
                continue;

            for (int j = 1; j < n - 1; j++) {
                char left = s.charAt(j - 1);
                char mid = s.charAt(j);
                char right = s.charAt(j + 1);

                if ((left < mid && right < mid) || // peak
                        (left > mid && right > mid)) { // valley

                    ans++;
                }
            }
        }

        return ans;
    }
}
