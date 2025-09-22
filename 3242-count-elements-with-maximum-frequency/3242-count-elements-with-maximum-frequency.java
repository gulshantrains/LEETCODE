class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0, ans = 0;
        for (int n : nums) {
            mp.merge(n, 1, Integer::sum);
            max = Math.max(mp.get(n), max);
        }
        for (Integer f : mp.values()) {
            if (f == max)
                ans += f;
        }
        return ans;
    }
}
/*
int[] freq = new int[101];
        int sum = 0, maxfreq = 0;

        for (int x : nums) {
            freq[x]++;
            maxfreq = Math.max(maxfreq, freq[x]);
        }

        for (int f : freq)
            if (f == maxfreq)
                sum += f;

        return sum;
*/