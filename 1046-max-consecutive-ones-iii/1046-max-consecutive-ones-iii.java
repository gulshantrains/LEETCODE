class Solution {
    public int longestOnes(int[] nums, int k) {  
        int i = 0, j = 0, ans = 0, n = nums.length;

        // zcnt: Counts the number of zeros within the current window [i, j]
        int zcnt = 0;

        while (j < n) {
            if (nums[j] == 0)
                zcnt++;

           
            while (zcnt > k) {
                if (nums[i] == 0)
                    zcnt--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);

            j++;
        }
        return ans;
    }
}

/*
Key Points for Revision (Max Consecutive Ones III):

1. Problem: Find the longest contiguous subarray of 1s, allowing at most k flips of 0s to 1s.
2. Technique: Sliding Window using two pointers, i (left) and j (right).
3. Goal: Maintain a window [i, j] such that the number of 0s (zcnt) within it is always <= k.
4. Pointers:
   - j (right pointer) always moves forward, expanding the window.
   - i (left pointer) moves forward *only when* the window constraint (zcnt > k) is violated, effectively shrinking the window.
5. Zero Count (zcnt):
   - Incremented when a 0 is included by moving j forward.
   - Decremented when a 0 is excluded by moving i forward (only if nums[i] was 0).
6. Window Validity Check: The condition 'zcnt > k' tells us the window [i, j] is currently invalid.
7. Shrinking Logic: When 'zcnt > k', move 'i' forward repeatedly in a 'while' loop until 'zcnt <= k' again. Remember to decrement 'zcnt' if the element at the old 'i' position was 0.
8. Updating Answer: After ensuring the window [i, j] is valid (by potentially shrinking), the length is (j - i + 1). Update the max length found so far.
9. Time Complexity: O(N). Both pointers i and j traverse the array at most once.
10. Space Complexity: O(1). Only a few extra variables are used.
*/