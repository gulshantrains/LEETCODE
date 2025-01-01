class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int x : nums2) {
            int answer = Bs(nums1, x);
            if (answer != -1)
                return answer;
        }
        return -1;
    }

    public int Bs(int[] arr, int num) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == num)
                return arr[mid];
            if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}