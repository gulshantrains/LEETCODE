class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();

        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            // Total shifts (0-25)
            int sf = shifts[i] % 26;

            char xx = (char) ((x - 'a' + sf) % 26 + 'a');
            ans.append(xx);
        }
        return ans.toString();
    }
}