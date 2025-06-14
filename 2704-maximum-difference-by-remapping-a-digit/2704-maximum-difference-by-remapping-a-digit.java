class Solution {
    public int minMaxDifference(int num) {
        String nm = num + ""; //String.ValueOf(num);
        String min = nm;
        int i = 0;

        while (i < nm.length() && nm.charAt(i) == '9')
            i++;
        if (i < nm.length()) {
            nm = nm.replace(nm.charAt(i), '9');
        }
        min = min.replace(min.charAt(0), '0');

        return Integer.valueOf(nm)-Integer.valueOf(min);

    }
}