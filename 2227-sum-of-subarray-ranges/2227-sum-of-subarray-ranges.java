class Solution {
    /**
     * Calculates the sum of ranges of all subarrays in the given array.
     * The range of a subarray is the difference between its largest and smallest element.
     */
    public long subArrayRanges(int[] nums) {
        // The sum of subarray ranges can be calculated as:
        // Sum of (Maximum of each subarray) - Sum of (Minimum of each subarray)
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    /**
     * Calculates the sum of the maximum elements of all possible subarrays.
     *
     * For each element arr[i], we find:
     * 1. pme[i]: Index of the Previous Most Element (greater than or equal to arr[i])
     * 2. nme[i]: Index of the Next Most Element (strictly greater than arr[i])
     *
     * The number of subarrays for which arr[i] is the maximum is given by
     * (i - pme[i]) * (nme[i] - i).
     */
    public long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        // pme[i] stores the index of the nearest element to the left of i
        // that is greater than or equal to arr[i]. If no such element, it's -1.
        int[] pme = prevMostElement(arr);
        // nme[i] stores the index of the nearest element to the right of i
        // that is strictly greater than arr[i]. If no such element, it's n.
        int[] nme = nextMostElement(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the number of subarrays where arr[i] is the maximum.
            // (i - pme[i]): number of choices for the left boundary (from pme[i] + 1 to i)
            // (nme[i] - i): number of choices for the right boundary (from i to nme[i] - 1)
            long num_subarrays = (long) (i - pme[i]) * (nme[i] - i);
            ans += (num_subarrays * arr[i]);
        }
        return ans;
    }

    /**
     * Finds the index of the Previous Most Element (previous greater or equal) for each element.
     * Uses a monotonic decreasing stack to store indices.
     * @return An array where pme[i] is the index of the nearest element to the left
     * that is greater than or equal to A[i], or -1 if none exists.
     */
    public int[] prevMostElement(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] pme = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            // Pop elements from stack that are less than or equal to A[i].
            // This maintains a stack of indices pointing to elements in decreasing order.
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }
            // If stack is empty, no previous greater or equal element exists, so -1.
            // Otherwise, the top of the stack is the index of the previous greater or equal element.
            pme[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i); // Push current element's index onto the stack
        }
        return pme;
    }

    /**
     * Finds the index of the Next Most Element (next strictly greater) for each element.
     * Uses a monotonic decreasing stack to store indices.
     *
     * @param A The input array.
     * @return An array where nme[i] is the index of the nearest element to the right
     * that is strictly greater than A[i], or A.length if none exists.
     */
    public int[] nextMostElement(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] nme = new int[n];

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack that are less than A[i].
            // This maintains a stack of indices pointing to elements in decreasing order.
            while (!st.isEmpty() && A[st.peek()] < A[i]) {
                st.pop();
            }
            // If stack is empty, no next strictly greater element exists, so n.
            // Otherwise, the top of the stack is the index of the next strictly greater element.
            nme[i] = st.isEmpty() ? n : st.peek();

            st.push(i); // Push current element's index onto the stack
        }
        return nme;
    }

    /**
     * Calculates the sum of the minimum elements of all possible subarrays.
     *
     * For each element arr[i], we find:
     * 1. ple[i]: Index of the Previous Less Element (strictly less than arr[i])
     * 2. nle[i]: Index of the Next Less Element (less than or equal to arr[i])
     *
     * The number of subarrays for which arr[i] is the minimum is given by
     * (i - ple[i]) * (nle[i] - i).
     *
     * @param arr The input integer array.
     * @return The sum of minimums of all subarrays.
     */
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // ple[i] stores the index of the nearest element to the left of i
        // that is strictly less than arr[i]. If no such element, it's -1.
        int[] ple = prevLessElement(arr);
        // nle[i] stores the index of the nearest element to the right of i
        // that is less than or equal to arr[i]. If no such element, it's n.
        int[] nle = nextLessElement(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the number of subarrays where arr[i] is the minimum.
            // (i - ple[i]): number of choices for the left boundary (from ple[i] + 1 to i)
            // (nle[i] - i): number of choices for the right boundary (from i to nle[i] - 1)
            long num_subarrays = (long) (i - ple[i]) * (nle[i] - i);
            ans += (num_subarrays * arr[i]);
        }
        return ans;
    }

    /**
     * Finds the index of the Previous Less Element (previous strictly less) for each element.
     * Uses a monotonic increasing stack to store indices.
     *
     * @param A The input array.
     * @return An array where ple[i] is the index of the nearest element to the left
     * that is strictly less than A[i], or -1 if none exists.
     */
    public int[] prevLessElement(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] ple = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            // Pop elements from stack that are greater than or equal to A[i].
            // This maintains a stack of indices pointing to elements in increasing order.
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            // If stack is empty, no previous strictly less element exists, so -1.
            // Otherwise, the top of the stack is the index of the previous strictly less element.
            ple[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i); // Push current element's index onto the stack
        }
        return ple;
    }

    /**
     * Finds the index of the Next Less Element (next less or equal) for each element.
     * Uses a monotonic increasing stack to store indices.
     *
     * @param A The input array.
     * @return An array where nle[i] is the index of the nearest element to the right
     * that is less than or equal to A[i], or A.length if none exists.
     */
    public int[] nextLessElement(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] nle = new int[n];

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack that are greater than A[i].
            // This maintains a stack of indices pointing to elements in increasing order.
            while (!st.isEmpty() && A[st.peek()] > A[i]) {
                st.pop();
            }
            // If stack is empty, no next less or equal element exists, so n.
            // Otherwise, the top of the stack is the index of the next less or equal element.
            nle[i] = st.isEmpty() ? n : st.peek();

            st.push(i); // Push current element's index onto the stack
        }
        return nle;
    }
}