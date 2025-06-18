class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n / 3][];

        Arrays.sort(nums);

        for (int i = 0; i < n; i += 3) {
            int[] temp = Arrays.copyOfRange(nums, i, i + 3);

            if (temp[2] - temp[0] > k)
                return new int[][] {};

            ans[i / 3] = temp;
        }

        return ans;
    }
}
// for (int i = 0; i < n; i += 3) {
//     int a = nums[i], b = nums[i + 1], c = nums[i + 2];

//     int maxV = Math.max(a, Math.max(b, c));
//     int minV = Math.min(a, Math.min(b, c));

//     if (maxV - minV > k)
//         return new int[][] {};

//     ans[i / 3][0] = a;
//     ans[i / 3][1] = b;
//     ans[i / 3][2] = c;
// }