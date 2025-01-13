class Solution {
    public int minimumLength(String s) {
        if (s.length() == 2)
            return 2;
        int[] ar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char xx = s.charAt(i);
            ar[xx - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int val = ar[i];

            if (val > 3 && val % 2 == 0)
                ans += 2;
            else if (val == 3 || (val > 3 && val % 2 != 0))
                ans += 1;
            else
                ans += val;
        }
        return ans;
    }
}