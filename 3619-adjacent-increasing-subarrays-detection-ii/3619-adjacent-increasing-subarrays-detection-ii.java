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