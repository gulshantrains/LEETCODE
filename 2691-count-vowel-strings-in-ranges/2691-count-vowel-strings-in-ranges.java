class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length + 1];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            if (isVowelString(words[i]))
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

    public boolean isVowelString(String str) {
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1));
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}