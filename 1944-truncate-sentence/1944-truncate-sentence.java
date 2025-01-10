class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder ss = new StringBuilder("");

        for (int i = 0; i < s.length() && k > 0; i++) {
            char x = s.charAt(i);
            if (x == ' ') {
                ss.append(" ");
                k--;
            } else {
                ss.append(x);
            }
        }
        return ss.toString().trim();
    }
}