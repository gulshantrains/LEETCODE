class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set=new HashSet<>();
        for(String x:nums) set.add(x);

        int total=1<<nums.length;

        for(int i=0; i<total; i++){
            String no=Integer.toBinaryString(i);
            no=String.format("%"+nums.length+"s",no).replace(' ','0');
            if(!set.contains(no)) return no;
        }  
        return "";
    }
}