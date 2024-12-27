class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] maxLeftScore = new int[n];
        maxLeftScore[0] = values[0];  // Initialize the first element
        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int maxRScore = values[i] - i;  // Right score (values[j] - j)
            maxScore = Math.max(maxRScore + maxLeftScore[i - 1], maxScore);

            int maxLScr = values[i] + i;  // Left score (values[i] + i)
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], maxLScr);
        }
        return maxScore;
    }
}