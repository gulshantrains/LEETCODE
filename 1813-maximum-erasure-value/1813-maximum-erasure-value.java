class Solution {
    public int maximumUniqueSubarray(int[] A) {
        int n = A.length, ans = Integer.MIN_VALUE, i = 0, j = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;

        while (j < n) {
            while (j < n && !mp.containsKey(A[j])) {
                sum += A[j];
                mp.merge(A[j], 1, Integer::sum);
                j++;
            }
            ans = Math.max(ans, sum);
            sum -= A[i];
            mp.merge(A[i], -1, Integer::sum);

            if (mp.get(A[i]) == 0)
                mp.remove(A[i]);
            i++;
        }
        return ans;
    }
}