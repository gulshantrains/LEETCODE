class Solution {
    public int maximumUniqueSubarray(int[] A) {
        int n = A.length, ans = Integer.MIN_VALUE, j=0;
        int sum = 0;

        boolean[] seen = new boolean[10001];
        for (int i = 0; i < n; i++) {
            //Duplicate is Found means remove all duplicate
            while (seen[A[i]]) {
                seen[A[j]] = false;
                sum -= A[j];
                j++;
            }
            //Add all non duplicate number
            sum += A[i];
            ans = Math.max(sum, ans);
            seen[A[i]] = true;
        }

        return ans;
    }
}