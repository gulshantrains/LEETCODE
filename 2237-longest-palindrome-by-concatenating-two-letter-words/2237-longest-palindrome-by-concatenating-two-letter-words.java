class Solution {
    public int longestPalindrome(String[] words) {
        // Create a 2D array to store counts of words.
        // Index [0][0] corresponds to "aa", [0][1] to "ab", ..., [25][25] to "zz".
        int[][] counts = new int[26][26];

        // Populate the counts array
        for (String word : words) {
            int char1 = word.charAt(0) - 'a'; 
            int char2 = word.charAt(1) - 'a'; 
            counts[char1][char2]++;
        }

        int ans = 0;
        boolean hasCenter = false; 

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // Current word represented by (char)('a' + i) + (char)('a' + j)

                // Case 1: Palindromic words like "gg", "aa", etc. (i == j)
                if (i == j) {
                    int count = counts[i][j];
                    // Each pair contributes 4 to the length
                    ans += (count / 2) * 4;
                    // If there's an odd number, one can be the center
                    if (count % 2 == 1) {
                        hasCenter = true;
                    }
                }
                // Case 2: Symmetric pairs like "lc" and "cl" (i != j)
                // To avoid double-counting, only process if i < j.
                // If we process (i, j), its reverse (j, i) will be handled by this logic.
                else if (i < j) {
                    int countWord = counts[i][j]; // Count of word "ij"
                    int countRev = counts[j][i];  // Count of word "ji" (reverse)

                    // The number of pairs we can form is limited by the minimum count
                    int pairs = Math.min(countWord, countRev);
                    ans += pairs * 4; // Each pair contributes 4 (e.g., "lc" + "cl" = "lccl")
                }
            }
        }

        if (hasCenter) {
            ans += 2;
        }

        return ans;
    }
}