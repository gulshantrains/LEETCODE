class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int n1 = 0, n2 = 0;
        int dif = Integer.MAX_VALUE;
      

        for (int i = left; i <= right; i++) {
            int temp = 0;
            if (i !=1 && isPrime(i)) {
                n1 = i;
                for (int j = i + 1; j <= right; j++) {
                    if (isPrime(j)) {
                        n2 = j;
                        temp = n2 - n1;
                        if (temp < dif) {
                            dif = temp;
                            ans[0] = n1;
                            ans[1] = n2;
                            if(dif<=2) return ans; //Waooooo
                        }
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}