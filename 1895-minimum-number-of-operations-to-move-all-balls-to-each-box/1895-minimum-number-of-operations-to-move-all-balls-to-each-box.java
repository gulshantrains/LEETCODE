class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i + 1; i < n && j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    x += Math.abs(j - i);
                }
            }
            for (int k = i - 1; i > 0 && k >= 0; k--) {
                if (boxes.charAt(k) == '1') {
                    x += Math.abs(i - k);
                }
            }

            ans[i] = x;

        }
        return ans;
    }
}