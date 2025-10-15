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
        int i=0;
        while (i < n) {
            int cur = res[i];

            ans = Math.max(ans, cur / 2);

            if (cur + i < n) {
                ans = Math.max(ans, Math.min(cur, res[cur + i]));
            }
            i = cur + i;
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

            if (prev != -1) { //We have atleast 2 subArray
                ans = Math.max(ans, Math.min(currLen, prev));
            }
            prev = currLen;
        }
        return ans;
    }
}
*/