class Solution {
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int[] freq = new int[101];
        Arrays.fill(freq, 0);

        for (var x : nums) {
            freq[x]++;
        }

        for (int x : freq) {
            if (x <= 1)
                continue;

            if (isPrime(x))
                return true;
        }
        return false;
    }
}