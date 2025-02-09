//Whenever SEE EXPRESSION TRY TO RESOLVE IT
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalgood = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //map.merge(val,number,mapping type)
            totalgood += map.merge(nums[i] - i, 1, Integer::sum) - 1;
        }
        return 1L*n*(n - 1) / 2 - totalgood;
    }
}
/*
 * MY PROBLEM:
 * -->I WAS UNABLE TO THINK OF TC LESS THAN O(n^2)
 * -->I WAS UNABLE TO THINK HOW WE CAN FIND IF WE HAVE SEEN ANY GOOD PAIR means
 * .......j-i==nums[j]-nums[i]
 * -->j - i != nums[j] - nums[i] ---||--- nums[i]-i != nums[j]-j
 */