class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int totalGCD = 0;   //gcd of the entire array
        int oneCount = 0;   

        
        for (int x : nums) {
            if (x == 1)
                oneCount++;
            totalGCD = gcd(totalGCD, x);
        }

        // we have 1 so need to convert the remaining (n - oneCount) elements to 1
        if (oneCount > 0)
            return n - oneCount;

        //GCD of the entire array is > 1, then it’s impossible to ever make a 1
        if (totalGCD > 1)
            return -1;

        //make a 1,  find the shortest subarray whose GCD == 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currGCD = nums[i];
            
            for (int j = i; j < n; j++) {
                currGCD = gcd(currGCD, nums[j]);

                // we got GCD = 1, stop expanding this subarray
                if (currGCD == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        //minimum operations =(minLen - 1) to make one element 1 + (n - 1) to spread 1 
        return (minLen - 1) + (n - 1);
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
