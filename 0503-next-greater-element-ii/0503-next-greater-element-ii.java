class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(temp, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                temp[st.pop()] = nums[i % n];
            }
            if (i < n)
                st.push(i);
        }
        return temp;
    }
}

//Brute Force
/*
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums.length; i++) {
            // Start from the next element and search circularly
            for (int k = 1; k < nums.length; k++) {
                int j = (i + k) % nums.length;
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
}
*/