class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        List<Integer> ans=new ArrayList<>();

        for(int z:nums){
            boolean found=false;

            for(int x=0; x<z; x++){
                if((x | (x+1))==z){
                    ans.add(x);
                    found=true;
                    break;
                }
            }
            if(!found){
                ans.add(-1);
            }
        }
        int[] result=new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            result[i]=ans.get(i);
        }
        
        return result;
    }
}