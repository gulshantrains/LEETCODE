class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        // Use a frequency array for ASCII characters or a HashMap for wider character sets
        // For simplicity and based on the current code's approach ('a' to 'z'), an array of size 256 is safer
        int[] charCount = new int[256]; // Increased size to handle all ASCII characters

        int i = 0; // Left pointer of the sliding window
        for (int j = 0; j < n; j++) { // Right pointer of the sliding window
            char currentChar = s.charAt(j);
            charCount[currentChar]++; // Increment count of the current character

            // Shrink the window from the left if the current character is a repeat
            while (charCount[currentChar] > 1) {
                char leftChar = s.charAt(i);
                charCount[leftChar]--; // Decrement count of the character at the left pointer
                i++; // Move the left pointer to the right
            }

            // Update the maximum length found so far
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}