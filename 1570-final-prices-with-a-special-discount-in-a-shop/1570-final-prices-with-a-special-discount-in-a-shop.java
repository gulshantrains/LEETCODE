class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] arr = new int[n];

        for (int i = 0; i <n; i++) {
            arr[i]=prices[i];
            for (int j = i + 1; j < n; j++) { // Check strictly after i
                if (prices[i] >= prices[j]) {
                    arr[i] = prices[i] - prices[j];
                    break; // break just after finding index
                }
            }
            
        }
        return arr;
    }
}