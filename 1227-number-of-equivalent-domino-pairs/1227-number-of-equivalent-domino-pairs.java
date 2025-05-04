class Solution {
    public int numEquivDominoPairs(int[][] domi) {
        int[] st=new int[100];
        int cnt=0;

        for(var x:domi){
            int val=Math.max(x[0], x[1])*10+Math.min(x[0],x[1]);

            cnt +=st[val];
            st[val]++;
        }
        return cnt;
        
    }
}