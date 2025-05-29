class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        int[] nle = new int[n];

        ple = prevLessElement(arr);
        nle = nextLessElement(arr);

        long ans = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long num_subarrays = (long) (i - ple[i]) * (nle[i] - i);

            long contribution = ((long)arr[i] * num_subarrays) % mod;
            ans = (ans + contribution) % mod;

        }
        return (int) ans % mod;
    }

    public int[] prevLessElement(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] ple = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return ple;
    }

    public int[] nextLessElement(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] nle = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        return nle;
    }
}