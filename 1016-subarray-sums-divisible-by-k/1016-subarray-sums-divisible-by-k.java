class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        int pre_sum = 0;
        
        int[] freq = new int[k];
        
        freq[0] = 1;
        
        for (int x : nums) {
            pre_sum += x;
            
            int m = ((pre_sum % k) + k) % k;
            
            cnt += freq[m];
            
            freq[m]++;
        }
        
        return cnt;
    }
}
