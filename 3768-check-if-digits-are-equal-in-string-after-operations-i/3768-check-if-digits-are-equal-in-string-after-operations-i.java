class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder cur = new StringBuilder(s);

        while (cur.length() > 2) {
            StringBuilder temp = new StringBuilder();

            for (int i = 1; i < cur.length(); i++) {
                int x = ((cur.charAt(i - 1) - '0') + (cur.charAt(i) - '0')) % 10;

                temp.append(x);
            }
            cur = temp;

        }

        return cur.charAt(0) == cur.charAt(1);
    }
}