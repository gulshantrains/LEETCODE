class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int curr = 0;
        if (deck.length <= 1)
            return false;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : deck)
            mp.merge(x, 1, Integer::sum);

        List<Integer> val = new ArrayList<>(mp.values());

        for (int x : val) {
            curr = gcd(x, curr);

            if (curr == 1)
                return false;
        }

        return true;
    }
}