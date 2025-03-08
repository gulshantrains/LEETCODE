class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] all=seive(right);
        ArrayList<Integer> prime=new ArrayList<>();
        int ans[]=new int[]{-1,-1};

        for(int i=Math.max(2,left); i<=right; i++){
            if(all[i]) prime.add(i);
        }
        if(prime.size()<2) return new int[]{-1,-1};
        int diff=Integer.MAX_VALUE;

        for(int i=1; i<prime.size(); i++){
            int temp=prime.get(i)-prime.get(i-1);

            if(temp<diff){
                diff=temp;
                ans[0]=prime.get(i-1);
                ans[1]=prime.get(i);
            }
        }
        return ans;
        
    }
    public boolean[] seive(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);

        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=2; i*j<=n; j++) isPrime[i*j]=false;
            }
        }
        return isPrime;
    }
}