class Solution {
    public int maximumCount(int[] nums) {

        IntPredicate p = num -> num > 0;
        IntPredicate n = num -> num < 0;

        int pos = (int) Arrays.stream(nums).filter(p).count();
        int neg = (int) Arrays.stream(nums).filter(n).count();

        return Math.max(pos, neg);
    }
}