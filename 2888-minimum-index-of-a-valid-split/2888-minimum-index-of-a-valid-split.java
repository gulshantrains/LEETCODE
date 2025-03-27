class Solution {
    public int minimumIndex(List<Integer> nums) {
        //Find a candidate for the dominant element using Boyer–Moore Voting Algorithm.
        int ele = nums.get(0); // Candidate element initialized to the first element.
        int k = 1;             // Counter for the candidate.
        for (int x : nums) {
            if (k == 0) {
                // Reset the candidate when the counter is zero.
                ele = x;
                k = 1;
            } else if (x != ele) {
                // Decrement the counter when the current element does not match the candidate.
                k--;
            } else {
                // Increment the counter when the current element matches the candidate.
                k++;
            }
        }
        
        // Step 2
        k = 0;
        for (int x : nums) {
            if (x == ele)
                k++; 
        }
        // If the candidate doesn't appear more than half the time, return -1.
        if (k < nums.size() / 2)
            return -1;

        // Step 3: Find the minimum valid split index.
        int presum = 0; 
        int ans = -1;   
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == ele) {
                presum++; 
            }
            // Left subarray (nums[0...i]): candidate count > (i+1)/2.
            // Right subarray (nums[i+1...end]): candidate count > (nums.size() - i - 1)/2.
            if (presum > (i + 1) / 2 && k - presum > (nums.size() - i - 1) / 2) {
                ans = i; // Valid split found.
                break;
            }
        }
        return ans;
    }
}
