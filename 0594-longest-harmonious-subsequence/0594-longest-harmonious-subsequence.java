//..SubSequence will always contains  2 Number [min,.....,min+1] Always
class Solution {
    public int findLHS(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();

        // Initialize the variable 'ans' to 0. This will store the maximum length of the harmonious subsequence found so far.
        int ans = 0;

        // --- Step 1: Count the frequency of each number ---
        // Iterate through each number 'x' in the input array 'A'.
        for (var x : A) mp.merge(x, 1, Integer::sum);
        

        // --- Step 2: Find the longest harmonious subsequence ---
        // Iterate through each unique number 'key' present in the map.
        for (var key : mp.keySet()) {
            // A harmonious subsequence consists of two numbers with a difference of 1.
            // For a given 'key', we only need to check for the existence of 'key + 1'.
            // Checking for 'key - 1' would be redundant as it will be handled when the loop gets to the 'key - 1' element.
            int need = key + 1;

            // Check if the map contains the required adjacent number ('key + 1').
            if (mp.containsKey(need)) {
                // If it exists, calculate the length of this harmonious subsequence
                // by adding the frequencies of the two numbers ('key' and 'need').
                int currLen = mp.get(need) + mp.get(key);

                // Update the final answer 'ans' if the current subsequence length 'currLen'
                // is greater than any length found before.
                ans = Math.max(ans, currLen);
            }
        }

        // Return the final maximum length found.
        return ans;
    }
}