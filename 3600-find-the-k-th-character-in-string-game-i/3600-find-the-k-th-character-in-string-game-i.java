class Solution {
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");

        while (s.length() < k + 1) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char x = s.charAt(i);
                char ans = (char) ((x - 'a' + 1) % 26 + 'a');

                s.append(ans);
            }
        }
        return s.charAt(k - 1);
    }
}