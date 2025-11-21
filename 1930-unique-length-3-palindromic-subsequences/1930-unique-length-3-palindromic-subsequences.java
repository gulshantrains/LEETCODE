import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last  = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // pass 1: compute first & last
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - 'a';
            if (first[v] == -1) first[v] = i;
            last[v] = i;
        }

        int[] middleMask = new int[26]; // middleMask[c] bit j set => char 'j' seen between first[c] and last[c]
        int active = 0; // bitmask of outer chars currently "active"

        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';

            // 1) remove all characters whose last index == i (they cannot use i as middle)
            // (we remove BEFORE processing i)
            for (int c = 0; c < 26; c++) {
                if (((active >> c) & 1) == 1 && last[c] == i) {
                    active &= ~(1 << c);
                }
            }

            // 2) current char acts as middle for every active outer char
            int a = active;
            while (a != 0) {
                int lsb = a & -a;
                int c = Integer.numberOfTrailingZeros(lsb);
                middleMask[c] |= (1 << cur);
                a &= a - 1; // clear lowest set bit
            }

            // 3) add current char to active if this is its first occurrence and it has a later last
            if (first[cur] == i && last[cur] > i) {
                active |= (1 << cur);
            }
        }

        int ans = 0;
        for (int c = 0; c < 26; c++) {
            ans += Integer.bitCount(middleMask[c]);
        }
        return ans;
    }
}
