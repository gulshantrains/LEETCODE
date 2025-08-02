class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        char[] cur = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[cur[j] - 'a']++;

                int min = (int) 1e9;
                int max = 0;

                for (int f : freq) {
                    if (f > 0) { // Only consider characters present in the substring
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }

                ans += (max - min); // beauty of substring s[i..j]
            }
        }

        return ans;
    }
}
