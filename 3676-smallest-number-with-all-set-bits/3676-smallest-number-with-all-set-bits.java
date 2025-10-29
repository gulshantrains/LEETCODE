class Solution {
    public int smallestNumber(int n) {
        int ans = 1;

        while (ans < n)
            ans = (ans << 1) | 1;

        return ans;
    }
}
// Left Shift means Multiply by 2 and then Take OR with 1 means add 1 to it
