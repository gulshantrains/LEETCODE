class Solution {
    // Euclidean algorithm for GCD
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1)
            return false;

        // Count frequency of each number
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : deck)
            mp.merge(x, 1, Integer::sum);

        // Compute GCD of all counts
        int curr = 0;                       // running gcd
        for (int count : mp.values()) {
            curr = gcd(curr, count);        // update running gcd
            // optional early exit: if curr becomes 1, no need to continue
            if (curr == 1) return false;
        }

        // If gcd of all counts >= 2, grouping possible
        return curr >= 2;
    }
}
