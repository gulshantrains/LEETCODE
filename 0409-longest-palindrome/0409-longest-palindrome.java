class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        boolean hasOdd = false;

        for (char c : s.toCharArray())
            mp.merge(c, 1, Integer::sum);

        for (int val : mp.values()) {
            if (val % 2 == 0) ans += val;
            else {
                ans += val - 1;   // use even part
                hasOdd = true;    // one odd can be middle
            }
        }

        return hasOdd ? ans + 1 : ans;
    }
}
