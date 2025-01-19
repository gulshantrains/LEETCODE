class Solution {
    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).filter(a -> a > 0).distinct().count();
    }
}