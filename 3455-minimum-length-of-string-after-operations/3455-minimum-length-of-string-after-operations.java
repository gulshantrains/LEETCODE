class Solution {
    public int minimumLength(String s) {
        if (s.length() == 2)
            return 2; // If s length is 2 then directly return its length
        int[] ar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++; // Count evry digit occurance
        }

        int ans = 0;
        for (var val : ar) {

            if (val > 3 && val % 2 == 0) // agr even times(2,4,22) occur krta hai
                ans += 2; // tb woo 2 baar he bache g
            else if (val == 3 || (val > 3 && val % 2 != 0)) // if odd times
                ans += 1; // or ==3 then sirf ek baar bache g woo
            else
                ans += val; // all other case me uske value ko count kro
        }
        return ans;
    }
}