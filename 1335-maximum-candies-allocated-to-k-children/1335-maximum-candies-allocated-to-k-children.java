class Solution {
    public int maximumCandies(int[] cndy, long k) {
        long sum = 0;
        for (var x : cndy)
            sum += x;
        if (sum < k)
            return 0;

        int l = 1, r = (int)Math.min(sum/k, Integer.MAX_VALUE);
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            // Check if we can give mid candies to each of k children
            long children = 0;
            for (int pile : cndy) {
                children += pile / mid;  // Count how many children can get mid candies
            }
            
            if (children >= k) {
                ans = mid;
                l = mid + 1;  // Try larger value
            } else {
                r = mid - 1;  // Try smaller value
            }
        }
        return ans;
    }
}