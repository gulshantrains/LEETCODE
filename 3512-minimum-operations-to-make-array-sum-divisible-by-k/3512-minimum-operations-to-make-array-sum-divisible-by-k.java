class Solution {
    public int minOperations(int[] nums, int k) {
        
        return Arrays.stream(nums).sum() % k;
    }
}
/*
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int x : nums)
            sum += x;

        return sum % k;
    }
}
*/