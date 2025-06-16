class Solution {
    public int maximumDifference(int[] n) {
        int ans = -1;
        if (n.length == 1)
            return ans;
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] < n[j])
                    ans = Math.max(ans, (n[j] - n[i]));

            }
        }
        return ans;
    }
}