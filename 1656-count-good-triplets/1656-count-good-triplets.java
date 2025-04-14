class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int ij = Math.abs(arr[i] - arr[j]);

                for (int k = j + 1; k < arr.length; k++) {
                    int jk = Math.abs(arr[j] - arr[k]);

                    if (ij <= a && jk <= b && Math.abs(arr[i] - arr[k]) <= c)
                        ans++;
                }
            }
        }
        return ans;
    }
}