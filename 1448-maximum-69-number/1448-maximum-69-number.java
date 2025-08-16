class Solution {
    public int maximum69Number(int num) {
        String n = "" + num;
        if (n.contains("6")) {
            n=n.replaceFirst("6", "9");
        } else
            return num;

        return Integer.valueOf(n);
    }
}