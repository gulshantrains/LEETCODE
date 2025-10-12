class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(var x: nums) mp.merge(x,1,Integer::sum);

        for(var x: mp.entrySet()){
            if(x.getValue()%k==0) ans+=(x.getValue()*x.getKey());
        }
        return ans;
    }
}
/*
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] freq = new int[101];
        int ans = 0;

        for (var x : nums)
            freq[x]++;

        for (int i = 0; i < 101; i++) {
            if (freq[i] % k == 0)
                ans += (freq[i] * i);

        }
        return ans;
    }
}
*/