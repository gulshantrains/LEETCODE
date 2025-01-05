class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffA = new int[n];
        StringBuilder ss = new StringBuilder();

        for (var x : shifts) {
            int l = x[0], r = x[1], sft = x[2];
            // Increment or decrement based on shift type
            diffA[l] += (sft == 0) ? -1 : 1;
            if (r + 1 < n)
                // Reverse the effect after range
                diffA[r + 1] += (sft == 0) ? 1 : -1;
        }

        // Compute the cumulative shifts 
        for (int i = 1; i < n; i++) {
            diffA[i] += diffA[i - 1];
        }
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            // Total shift for that index '%26' for bring in range of 0-25
            int shift = diffA[i] % 26;
            // For Wrap Around 'z'->'a' or 'a'-'z'
            if (shift < 0)
                shift += 26;

            char ans = (char) (((x - 'a') + shift) % 26 + 'a');
            ss.append(ans);

        }
        return ss.toString();
    }
}