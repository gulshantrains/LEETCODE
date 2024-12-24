class Solution {
    private int leftSearch(int[] a, int left, int right, int target) {
        int l = left;
        int r = right;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;

    }

    private int rightSearch(int[] a, int left, int right, int target) {
        int l = left;
        int r = right;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;

    }

    public int search(int[] nums, int target) {
        int idx = pivotidx(nums);
        int lidx = leftSearch(nums, 0, idx - 1, target);
        int ridx = rightSearch(nums, idx, nums.length - 1, target);

        if (lidx == -1 && ridx == -1)
            return -1;

        return (lidx > ridx) ? lidx : ridx;

    }

    private int pivotidx(int[] a) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
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