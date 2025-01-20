class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int flower_need = m * k;
        int n = bloomDay.length;

        // if flower is less then not possible to make bouquet
        if (flower_need > n)
            return -1;

        int maxBloom = 0;
        for (int day : bloomDay) {
            maxBloom = Math.max(maxBloom, day);
        }

        return bs(bloomDay, m, k, maxBloom);
    }

    public int bs(int[] arr, int m, int k, int maxBloom) {
        int res = -1;
        int l = 1;
        int r = maxBloom;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // agr mid day tak bouquet ready hai then aur minimum check krte hai
            // wrna left ko move krte hai
            if (bloom(arr, mid, m, k)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean bloom(int[] ar, int day, int m, int k) {
        int consec = 0, boqmade = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] <= day) {// mtlb flower ready hai bouquet k liye
                consec++; // adjacent k liye ek flower mil gaya
            } else {
                consec = 0;// count zero kro adjacent nhi hai
            }
            if (consec == k) { // flower is ready for bouquet
                boqmade++;
                consec = 0; // count reset
            }
        }
        return boqmade >= m;
    }
}