//.......(23+0) % 6->5
//(23+3) % 6->2
//(23+3+2) % 6->4
//......(23+3+2+7) % 6->5
//If we add some multiple of k then % will be always same
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2) return false;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);//For extra use of direct divisibilty
        int sum=0;

        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
            int val=sum %k;
            if(map.containsKey(val)){
                int idx=map.get(val);
                if(i-idx>=2) return true;
            }else
             map.put(val,i);
        }
        return false;
    }
}