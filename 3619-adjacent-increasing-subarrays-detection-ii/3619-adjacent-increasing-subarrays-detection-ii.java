class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        res[n - 1] = 1; 
        int ans = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                res[i] = res[i + 1] + 1;  
            } else {
                res[i] = 1;               
            }
        }

        int i = 0;
        while (i < n) {
            int cur = res[i]; // length of current increasing run

            // Case 1: Two adjacent increasing subarrays can be inside the same run.
            // For example, run length = 6 → two length-3 subarrays can fit.
            ans = Math.max(ans, cur / 2);

            // Case 2: Two adjacent increasing subarrays can come from
            // the current run and the next run (i.e., right after current ends).
            // Example: [1,2,3] [4,5,6], cur=3, next=3 ⇒ k = min(3,3) = 3
            if (i + cur < n) {
                ans = Math.max(ans, Math.min(cur, res[i + cur]));
            }

            // Step 3: Move to the next increasing run (skip current run length)
            i = i + cur;
        }

        return ans;
    }
}

/*
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.size(), prev = -1, ans = 0, i = 0;

        while (i < n) {
            st.clear();
            st.push(nums.get(i));
            i++;

            while (i < n && st.peek() < nums.get(i)) {
                st.push(nums.get(i));
                i++;
            }
            int currLen = st.size();

            ans=Math.max(ans, currLen/2);

            if (prev != -1) { //We have atleast 2 subArray
                ans = Math.max(ans, Math.min(currLen, prev));
            }
            prev = currLen;
        }
        return ans;
    }
}
*/