class Solution {
    public int maximumCount(int[] nums) {

        IntPredicate lambdap = num -> num > 0;
        IntPredicate lambdan = num -> num < 0;

        int pos = (int) Arrays.stream(nums).filter(lambdap).count();
        int neg = (int) Arrays.stream(nums).filter(lambdan).count();

        return Math.max(pos, neg);
    }
}