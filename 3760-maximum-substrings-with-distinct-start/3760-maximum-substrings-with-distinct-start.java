class Solution {
    public int maxDistinct(String s) {
        int[] freq = new int[26];
        int ans = 0;

        for (char x : s.toCharArray()) {
            if (freq[x - 'a'] == 0) {
                ans++;
            }
            freq[x - 'a']++;
        }

        return ans;
    }
}