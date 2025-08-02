class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int min = 100_000_000;
                int max = -100_000_000;

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
