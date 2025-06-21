class Solution {
    public int minimumDeletions(String word, int k) {
        // Step 1: Calculate character frequencies
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Initialize minimum deletions to the maximum possible (delete all characters)
        // This is a safe upper bound.
        int minTotalDeletions = word.length();

        // If the word is empty, no deletions are needed.
        if (word.length() == 0) {
            return 0;
        }

        // Step 2: Iterate through all possible values that a minimum frequency (minF) could take.
        // The minimum frequency can range from 0 (if we delete all occurrences of a char)
        // up to the maximum possible frequency in the word (word.length()).
        // We iterate from 0 to word.length() to cover all scenarios for 'minF'.
        for (int possibleMinFreq = 0; possibleMinFreq <= word.length(); possibleMinFreq++) {
            int currentDeletions = 0; // Deletions calculated for this specific 'possibleMinFreq' scenario

            // Step 3: For each 'possibleMinFreq', calculate deletions needed for all characters
            for (int f_val : freq) {
                if (f_val == 0) {
                    continue; // Skip characters that are not present
                }

                if (f_val < possibleMinFreq) {
                    // If a character's frequency is less than our 'possibleMinFreq',
                    // we must delete all occurrences of this character.
                    currentDeletions += f_val;
                } else if (f_val > possibleMinFreq + k) {
                    // If a character's frequency is greater than the allowed upper bound (possibleMinFreq + k),
                    // we must delete characters until it reaches this upper bound.
                    currentDeletions += (f_val - (possibleMinFreq + k));
                }
                // If possibleMinFreq <= f_val <= possibleMinFreq + k,
                // this frequency is already within our desired range, so no deletions are needed for it.
            }
            
            // Update the overall minimum deletions found so far.
            minTotalDeletions = Math.min(minTotalDeletions, currentDeletions);
        }

        // Step 4: Return the minimum deletions found.
        return minTotalDeletions;
    }
}