class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int v : nums) {
            int pos = Collections.binarySearch(res, v);

            if (pos < 0)
                pos = -(pos + 1);
            if (pos == res.size()) {
                res.add(v);
            } else {
                res.set(pos, v);
            }
        }
        return res.size();
    }
}