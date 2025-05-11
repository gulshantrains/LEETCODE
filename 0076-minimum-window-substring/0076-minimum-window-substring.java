class Solution {
    public String minWindow(String s, String t) {
        // Frequency map to store required characters from t
        int[] map = new int[128]; // Covers all ASCII characters

        // Fill the map with frequency of characters in t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int i = 0, j = 0; 
        int reqd = t.length(); // Total characters needed
        int sidx = -1; // Starting index of minimum window
        int minLen = Integer.MAX_VALUE; // Length of the minimum window found

        while (j < s.length()) {
            char tm = s.charAt(j);

            // If current char is part of t and still needed, reduce required count
            if (map[tm] > 0) {
                reqd--;
            }
            // Decrease the count from the map (even if not needed, to balance future exits)
            map[tm]--;

            // When all characters are covered (reqd == 0)
            while (reqd == 0) {
                // Update minimum window if this one is smaller
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    sidx = i;
                }

                // Try to shrink window from the left
                char tg = s.charAt(i);
                map[tg]++; // Add back the leftmost character

                // If it's a character in t, we now need one more of it
                if (map[tg] > 0) {
                    reqd++;
                }

                i++; 
            }

            j++; 
        }

        return (sidx == -1 ? "" : s.substring(sidx, sidx + minLen));
    }
}
