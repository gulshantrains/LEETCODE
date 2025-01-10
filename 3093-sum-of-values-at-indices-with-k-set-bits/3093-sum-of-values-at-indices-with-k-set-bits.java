class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int cnt = 0;

        for (int i = 0; i < nums.size(); i++) {
            int bitc = Integer.bitCount(i);
            if (bitc == k) {
                cnt += nums.get(i);
            }
        }
        return cnt;
    }
}