class Solution {
    /**
     * Calculates the maximum points obtainable by removing "ab" and "ba" substrings.
     *
     * @param s The input string consisting of lowercase English letters.
     * @param x The points gained for removing "ab".
     * @param y The points gained for removing "ba".
     * @return The maximum possible score.
     */
    public int maximumGain(String s, int x, int y) {
        // Ensure the higher score is always 'x' for the pair 'p1', 'p2'
        // This avoids code duplication by handling both cases with one function.
        if (x < y) {
            // If 'ba' has more points, we can treat it as the primary pair
            // by swapping the scores and the characters we search for.
            return solve(s, y, x, 'b', 'a');
        } else {
            // If 'ab' has more or equal points, proceed normally.
            return solve(s, x, y, 'a', 'b');
        }
    }

    /**
     * A helper function that executes the two-pass greedy removal strategy.
     *
     * @param s          The input string.
     * @param highScore  The score for the prioritized pair.
     * @param lowScore   The score for the secondary pair.
     * @param highP1     The first character of the high-score pair (e.g., 'a').
     * @param highP2     The second character of the high-score pair (e.g., 'b').
     * @return The total points calculated.
     */
    private int solve(String s, int highScore, int lowScore, char highP1, char highP2) {
        int totalPoints = 0;
        StringBuilder sb = new StringBuilder();

        // Pass 1: Greedily remove the high-score pair (e.g., "ab")
        for (char c : s.toCharArray()) {
            // If the stack top and current char form the high-score pair
            if (c == highP2 && sb.length() > 0 && sb.charAt(sb.length() - 1) == highP1) {
                sb.deleteCharAt(sb.length() - 1);
                totalPoints += highScore;
            } else {
                sb.append(c);
            }
        }

        // The remaining string after the first pass
        String remainingStr = sb.toString();
        // Clear the StringBuilder for the second pass
        sb.setLength(0);

        // Pass 2: Greedily remove the low-score pair (e.g., "ba")
        for (char c : remainingStr.toCharArray()) {
            // The low-score pair is the reverse of the high-score pair (highP2, highP1)
            if (c == highP1 && sb.length() > 0 && sb.charAt(sb.length() - 1) == highP2) {
                sb.deleteCharAt(sb.length() - 1);
                totalPoints += lowScore;
            } else {
                sb.append(c);
            }
        }

        return totalPoints;
    }
}
