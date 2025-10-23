class Solution {
    public boolean hasSameDigits(String s) {

        while (s.length() > 2) {
            StringBuilder temp = new StringBuilder();

            for (int i = 1; i < s.length(); i++) {
                int x = ((s.charAt(i - 1) - '0') + (s.charAt(i) - '0')) % 10;

                temp.append(x);
            }
            s = temp.toString();

        }

        return s.charAt(0) == s.charAt(1);
    }
}