class Solution {
    /**
     * Main function to calculate sum of all subarray ranges.
     * Range of a subarray = max - min.
     * So, total sum = sum of all subarray maximums - sum of all subarray minimums.
     */
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    /**
     * Calculates the total sum of maximum values across all subarrays.
     * Each element arr[i] contributes as the maximum in:
     * (i - prevGreater[i]) * (nextGreater[i] - i) subarrays.
     */
    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] prevGreater = prevGreaterOrEqual(arr);
        int[] nextGreater = nextGreaterStrict(arr);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            sum += (long) arr[i] * left * right;
        }
        return sum;
    }

    /**
     * Calculates the total sum of minimum values across all subarrays.
     * Each element arr[i] contributes as the minimum in:
     * (i - prevLess[i]) * (nextLess[i] - i) subarrays.
     */
    private long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prevLess = prevLessStrict(arr);
        int[] nextLess = nextLessOrEqual(arr);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            sum += (long) arr[i] * left * right;
        }
        return sum;
    }

    /**
     * Finds index of previous element that is >= current element.
     * Monotonic decreasing stack.
     */
    private int[] prevGreaterOrEqual(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    /**
     * Finds index of next element that is > current element.
     * Monotonic decreasing stack.
     */
    private int[] nextGreaterStrict(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] < A[i]) st.pop();
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    /**
     * Finds index of previous element that is < current element.
     * Monotonic increasing stack.
     */
    private int[] prevLessStrict(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    /**
     * Finds index of next element that is <= current element.
     * Monotonic increasing stack.
     */
    private int[] nextLessOrEqual(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) st.pop();
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }
}
