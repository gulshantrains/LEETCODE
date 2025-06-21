import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char x : word.toCharArray()) {
            freq[x - 'a']++;
        }

        List<Integer> mp = new ArrayList<>();
        for (int x : freq) {
            if (x != 0)
                mp.add(x);
        }

        Collections.sort(mp);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < mp.size(); i++) {
            int target = mp.get(i);
            int delete = 0;

            // Delete all smaller than target
            for (int j = 0; j < i; j++) {
                delete += mp.get(j);
            }

            // Delete only what exceeds (target + k)
            for (int j = mp.size() - 1; j > i; j--) {
                int val = mp.get(j);
                if (val <= target + k)
                    break; // Sorted list: remaining will also be ≤ target + k
                delete += val - (target + k);
            }

            ans = Math.min(ans, delete);
        }

        return ans;
    }
}
