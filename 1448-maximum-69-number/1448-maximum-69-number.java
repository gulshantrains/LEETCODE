class Solution {
    public int maximum69Number(int num) {
        String n = "" + num;
        n = n.replaceFirst("6", "9");

        return Integer.parseInt(n);
    }
}