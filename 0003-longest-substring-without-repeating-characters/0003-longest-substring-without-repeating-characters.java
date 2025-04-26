class Solution {
    public int lengthOfLongestSubstring(String s) {
        //It will maintain count in window
        int[] idx = new int[150];

        int n = s.length(), ans = 0, i = 0;

        for (int j = 0; j < n; j++) {
            char curr = s.charAt(j);

            idx[curr]++;

            while (idx[curr] > 1) {
                char left = s.charAt(i);
                idx[left]--;
                i++;
            }
            ans = Math.max(j - i + 1, ans);
        }
        return ans;
    }
}