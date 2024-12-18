class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                prices[st.peek()] = prices[st.peek()] - prices[i];
                st.pop();
            }
            st.push(i);
        }
        return prices;
    }
}