class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (daysTaking(weights, mid, days)) {
                r = mid - 1; //It means that mid is delivering in <=days so we may check
            } else {          //Some more values before mid we may get exact
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean daysTaking(int[] arr, int weight, int days) {
        int dys = 0; // Number of days used
        int i = 0; // Pointer for the array

        while (i < arr.length) {
            int k = weight; // Start each day with full capacity

            // Load packages for the current day
            while (i < arr.length && k >= arr[i]) {
                k -= arr[i];
                i++;
            }

            dys++; // Increment the number of days used

            // If days exceed the allowed limit, return false immediately
            if (dys > days) {
                return false;
            }
        }

        return dys<=days; // Feasible if all packages are loaded within the allowed days
    }

}