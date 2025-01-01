class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int oneCount = 0, zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                oneCount++;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                oneCount--;
            } else {
                zeroCount++;
            }
            ans = Math.max(ans, (oneCount + zeroCount));
        }
        return ans;

    }
}