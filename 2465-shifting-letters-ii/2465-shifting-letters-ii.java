class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffA = new int[n];
        StringBuilder ss = new StringBuilder();

        for (var x : shifts) {
            int l = x[0];
            int r = x[1];
            int sft = x[2];

            if (sft == 0) {
                diffA[l] -= 1;
                if (r + 1 < n)
                    diffA[r + 1] += 1;
            } else {
                diffA[l] += 1;
                if (r + 1 < n)
                    diffA[r + 1] -= 1;
            }
        }
        // Cumulative Shift
        for (int i = 1; i < n; i++) {
            diffA[i] += diffA[i - 1];
        }
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            // Total shift for that index %26 for bring in range of 0-25
            int shift = diffA[i] % 26;
            // For Wrap Around 'z'->'a' or 'a'-'z'
            if (shift < 0)
                shift += 26;

            char ans = (char)(((x - 'a') + shift) % 26 + 'a');
            ss.append(ans);

        }
        return ss.toString();
    }
}