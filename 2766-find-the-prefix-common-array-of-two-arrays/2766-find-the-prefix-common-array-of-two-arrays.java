class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length + 1]; // Freq array lete hai to count number appread till i index
        int[] ans = new int[A.length];
        // TC->O(n)
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++; // Increase the count of number jo A me aaya hai
            // Increase the count of number jo B me aaya hai

            if (freq[A[i]] == 2)
                cnt++;

            freq[B[i]]++;
            if (freq[B[i]] == 2)
                cnt++;

            ans[i] = cnt;
        }
        return ans;
    }
}