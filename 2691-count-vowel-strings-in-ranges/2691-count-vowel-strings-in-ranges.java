class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] count = new int[words.length + 1];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String x = words[i];
            if (x.matches("^[aeiou]$") || x.matches("^[aeiou].*[aeiou]$")) {
                count[i + 1] = count[i] + 1;
                set.add(x);
            } else {
                count[i + 1] = count[i];
            }

        }
        for (int i = 0; i < queries.length; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            ans[i] = count[end + 1] - count[start];
        }
        return ans;
    }
}