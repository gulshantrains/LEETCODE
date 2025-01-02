class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length + 1];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)))
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

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}