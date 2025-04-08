class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[101];
        Arrays.fill(count, 0);
        int j=0,ans=0;

        for (var x : nums)
            count[x] += 1;

        for (int i = 0; i < 101; i++) {
            if(count[i]>1){
                int k=3;
                while(j<nums.length && k>0){
                    count[nums[j]] -=1;
                    k--;
                    j++;
                }
                ans++;
                i=0;
            }
        }
        return ans;
    }
}