class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums2)
            set.add(x);

        for (Integer x : nums1) {
            if (set.contains(x))
                return x;
        }
        return -1;

    }

}