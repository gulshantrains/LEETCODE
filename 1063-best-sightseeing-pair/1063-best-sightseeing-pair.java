class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = 0;

        Stack<Integer> stck = new Stack<>();
        stck.push(values[0]);

        for (int i = 1; i < n; i++) {
            max = Math.max(max, stck.peek() + values[i] - i);

            if (values[i] + i > stck.peek())
                stck.push(values[i] + i);
        }
        return max;
    }   
}