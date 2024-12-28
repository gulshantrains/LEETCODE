class Solution {
    public boolean canWemake(int[] arr, int divsor, int thrs) {
        int total=0;
        for (int x : arr) {
            total += Math.ceilDiv(x, divsor);

            if (total > thrs)
                return false;
        }
        return total <= thrs;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l = 1, r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canWemake(nums, mid, threshold)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}