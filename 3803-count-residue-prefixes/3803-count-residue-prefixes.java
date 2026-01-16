class Solution {
    public int residuePrefixes(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            mp.merge(s.charAt(i), 1, (a, b) -> a + b);
            int len = i + 1;

            if (mp.size() == len % 3)
                ans++;
        }

        return ans;
    }
}