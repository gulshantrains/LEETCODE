class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;  // prune

                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b) continue;  // prune
                    if (Math.abs(arr[i] - arr[k]) > c) continue;  // prune

                    ans++;
                }
            }
        }
        return ans;
    }
}
