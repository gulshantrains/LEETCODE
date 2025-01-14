class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int no : nums) {
            if (no > max) {
                max2 = max;
                max = no;
            } else if (no > max2) {
                max2 = no;
            }
        }
        return (max - 1) * (max2 - 1);

    }
}