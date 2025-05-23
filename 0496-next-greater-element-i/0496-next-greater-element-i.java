class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n1.length];

        for(var num: n2){
            while(!st.isEmpty() && st.peek()<num) mp.put(st.pop(),num);
            st.push(num);
        }
        for(int i=0; i<n1.length; i++) n1[i]=mp.getOrDefault(n1[i],-1);
        return n1;

    }
}
