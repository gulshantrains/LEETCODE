class Solution {
    private boolean leftSearch(int[] a, int left, int right, int target) {
        int l = left;
        int r = right;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;

    }

    public boolean search(int[] nums, int target) {
        int idx = pivotidx(nums);
        boolean lidx = leftSearch(nums, 0, idx - 1, target);
        boolean ridx = leftSearch(nums, idx, nums.length - 1, target);

        return lidx || ridx;

    }

    private int pivotidx(int[] a) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            while (l < r && a[l] == a[l + 1]) //SKIP REPEATED ELEMENT 
                l++;
            while (l < r && a[r - 1] == a[r])
                r--;

            int mid = l + (r - l) / 2;

            if (a[mid] > a[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
