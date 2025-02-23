class Solution {
    public boolean hasSameDigits(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();

        while (n > 2) {
            char[] temp = new char[n - 1];
            for (int i = 1; i < ss.length; i++) {
                int x = (ss[i - 1] - '0') + (ss[i] - '0');
                temp[i - 1] = (char) ((x % 10) + '0');
            }
            ss = temp;
            n--;
        }
        return (ss.length == 2) && (ss[0] == ss[1]);
    }
}