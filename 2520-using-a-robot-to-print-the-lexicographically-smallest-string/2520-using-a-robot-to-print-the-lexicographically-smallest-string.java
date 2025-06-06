class Solution {
    public String robotWithString(String s) {
        int n = s.length();

        char[] mcr = new char[n + 1];
        mcr[n] = '{';

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                mcr[i] = s.charAt(i);
            } else {
                mcr[i] = (char) Math.min(s.charAt(i), mcr[i + 1]);
            }
        }

        Deque<Character> t = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder(); // The final string written on paper

        for (int i = 0; i < n; i++) {

            t.addLast(s.charAt(i));

            while (!t.isEmpty() && t.peekLast() <= mcr[i + 1]) {
                ans.append(t.removeLast());
            }
        }

        // Append any remaining characters from t to p.
        while (!t.isEmpty()) {
            ans.append(t.removeLast());
        }

        return ans.toString();
    }
}