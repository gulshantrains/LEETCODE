class Solution {
    public int missingMultiple(int[] nums, int k) {
       Set<Integer> st=new HashSet<>();
       for(int x: nums) st.add(x);

       for(int i=1; i<=101; i++){
        int temp=k*i;

        if(!st.contains(temp)) return temp;

       }
       return -1; 
    }
}