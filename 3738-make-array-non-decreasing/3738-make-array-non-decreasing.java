class Solution {
    public int maximumPossibleSize(int[] nums) {
        Stack<Integer> st = new Stack<>();
        
        for (var x : nums) {
            if (st.isEmpty()) {
                st.push(x);
            } else if (!st.isEmpty()) {
                if (x >= st.peek())
                    st.push(x);
                else {
                    int temp = Math.max(st.pop(), x);
                    st.push(temp);
                }
            }
        }
        return st.size();
    }
}