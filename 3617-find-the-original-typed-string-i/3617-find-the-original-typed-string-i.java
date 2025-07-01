class Solution {
    public int possibleStringCount(String word) {
        char[] temp = word.toCharArray();
        int ans = 0;

        char prev = temp[0];
        for (int i = 1; i < temp.length; i++) {
            char cur = temp[i];

            if (prev == cur)
                ans++;
            else
                prev = cur;
        }

        return ans + 1;
    }
}