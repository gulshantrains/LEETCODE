class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        String reversedStr = sb.reverse().toString();

        try {
            int reversed = Integer.parseInt(reversedStr);
            return isNegative ? -reversed : reversed;
        } catch (NumberFormatException e) {
            // If it overflows
            return 0;
        }
    }
}
