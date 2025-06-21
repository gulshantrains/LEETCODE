class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = Integer.MAX_VALUE; // Initialize answer for minimization

        // Step 2: Try using each non-zero frequency as the target frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            int target = freq[i]; // Assume we want all other frequencies in [target, target + k]
            int delete = 0;       // Number of deletions needed for this target

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0 || i == j) continue;

                if (freq[j] < target) {
                    // If frequency is less than target, delete all characters
                    // because we can't increase frequency
                    delete += freq[j];
                } else if (freq[j] > target + k) {
                    // If frequency is greater than target + k, reduce it
                    // so the difference becomes ≤ k
                    delete += freq[j] - (target + k);
                }
                // If freq[j] is in [target, target + k], do nothing (valid range)
            }

            // Update the answer with the minimum deletions found so far
            ans = Math.min(ans, delete);
        }

        return ans; // Return the minimum deletions required
    }
}
