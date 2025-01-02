class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length + 1];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("^[aeiou]$") || words[i].matches("^[aeiou].*[aeiou]$"))
                prefixSum[i + 1] = prefixSum[i] + 1;

            else
                prefixSum[i + 1] = prefixSum[i];
        }
        for (int j = 0; j < queries.length; j++) {
            int start = queries[j][0];
            int end = queries[j][1];

            ans[j] = prefixSum[end + 1] - prefixSum[start];
        }
        return ans;
    }
}