class Solution {
    public String answerString(String word, int nF) {
        int n = word.length();
        String ans = "";

        // If there's only one friend, the entire word is given to them

        if (nF == 1)
            return word;

        // Calculate the maximum possible length for any single string in a valid split.
        // This is `n` (total length) minus `nF-1` (minimum 1 char for each of the other friends).

        int maxL = (n - (nF - 1));

        for (int i = 0; i < n; i++) {

            // Determine the actual length of the substring to consider.
            // It's limited by `maxL` and the remaining characters in the word from index `i`.

            int act = Math.min(maxL, n - i);

            // If no valid length can be formed from this position (e.g., if maxL is too small), skip

            if (act <= 0) {
                continue;
            }

            String temp = word.substring(i, i + act);
            /*In our case:
            beginIndex = i
            endIndex = i + act
            So, the length of the substring will be (i + act) - i = act.(Which is our desired length)
            */

            if (ans.compareTo(temp) <= 0) {
                ans = temp;
            }
        }
        return ans;
    }
}