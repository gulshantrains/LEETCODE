import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        
        // Step 1: Build frequency map
        for (char x : word.toCharArray())
            freq[x - 'a']++;

        // Step 2: Extract non-zero frequencies into a list
        List<Integer> mp = new ArrayList<>();
        for (int x : freq) {
            if (x != 0)
                mp.add(x);
        }

        Collections.sort(mp); // Sort to simplify logic
        int ans = Integer.MAX_VALUE;

        // Step 3: Try each frequency as the target lower bound
        for (int i = 0; i < mp.size(); i++) {
            int target = mp.get(i);
            int delete = 0;

            for (int j = 0; j < mp.size(); j++) {
                int current = mp.get(j);

                if (current < target) {
                    // If frequency is less than target, delete all of it
                    delete += current;
                } else if (current > target + k) {
                    // If frequency exceeds allowed range, trim to (target + k)
                    delete += current - (target + k);
                }
                // else: do nothing, it's within range
            }

            ans = Math.min(ans, delete);
        }

        return ans;
    }
}
