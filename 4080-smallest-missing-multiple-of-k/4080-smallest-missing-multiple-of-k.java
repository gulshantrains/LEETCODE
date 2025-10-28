class Solution {
    public int missingMultiple(int[] nums, int k) {
       Set<Integer> st=new HashSet<>();
       for(int x: nums) st.add(x);
       
       int nm=1;

       while(st.contains(nm *k)) nm++;

       return nm*k; 
    }
}