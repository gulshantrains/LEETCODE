class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, idx = -1;

        if (n < 3)
            return false;

        // Find the peak index
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
        }

        // No peak found
        if (idx == -1)
            return false;

        // Increasing before the peak (strictly)
        for (int i = 0; i < idx; i++) {
            if (arr[i] >= arr[i + 1])   // should be strictly increasing
                return false;
        }

        // Decreasing after the peak (strictly)
        for (int i = idx; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1])   // should be strictly decreasing
                return false;
        }

        return true;
    }
}
