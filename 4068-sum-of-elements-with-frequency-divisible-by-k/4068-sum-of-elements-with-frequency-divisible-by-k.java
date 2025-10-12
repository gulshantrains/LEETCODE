class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
      int[] freq=new int[101];
      int ans=0;

      for(int x: nums) freq[x]++;

      for(int i=0; i<101; i++){
        if(freq[i]%k==0)
            ans+=(freq[i]*i);
    
      }
      return ans;
    }
}