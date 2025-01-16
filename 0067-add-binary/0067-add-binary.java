class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Start from the end of both strings
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0; // Get digit from a or 0 if out of bounds
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0; // Get digit from b or 0 if out of bounds

            int sum = digitA + digitB + carry;
            carry = sum / 2; // Compute carry for next iteration
            result.append(sum % 2); // Append the current digit (sum mod 2)

            i--;
            j--;
        }

        // Reverse the result since we constructed it from the least significant to most significant
        return result.reverse().toString();
    }
}
