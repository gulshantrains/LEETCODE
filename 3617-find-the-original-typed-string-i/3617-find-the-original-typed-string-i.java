class Solution {
    public int possibleStringCount(String word) {
        int ans = 0;

        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char cur = word.charAt(i);

            if (prev == cur)
                ans++;
            else
                prev = cur;
        }

        return ans + 1;
    }
}