class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        return nums[bs(nums)];
    }

    private int bs(int[] a) {
        int l = 0, r = a.length - 1;
        int n = a.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid < n-1 && mid > 0) {
                if (a[mid] != a[mid + 1] && a[mid] != a[mid - 1])
                    return mid;
            }
            if (mid == 0 && a[mid] != a[mid + 1]) {
                return mid;
            }
            if (mid == n-1 && a[mid] != a[mid - 1]) {
                return mid;
            }

            if (mid < n - 1 && a[mid] == a[mid + 1]) {
                if (mid % 2 != 0) {
                    r = mid - 1;
                } else {
                    l = mid + 2;
                }
            } else {
                if (mid % 2 == 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}