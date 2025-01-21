/*
Non-Empty subArray means index should be 0,1,2... not 1,3,2
Largest sum of subArray is minimized means -->jitne v case possible honge
unme se jitne v maximum value hai unke minimum chaiye
*/
class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();
        int ans=0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, k)) {
                ans=mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int[] arr, int subAsum, int k) {
        if (arr.length < k)
            return false;

        int subArcnt = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= subAsum) {
                sum += arr[i];
            } else {
                subArcnt++;
                sum = arr[i];
            }
            if (subArcnt > k)
                return false;
        }
        return true;
    }
}