class Solution {
    public int[] countBits(int n) {
        int[] a=new int[n+1];

        for(int i=0; i<=n; i++){
            int c=Integer.bitCount(i);
            a[i]=c;
        }
        return a;
    }
}