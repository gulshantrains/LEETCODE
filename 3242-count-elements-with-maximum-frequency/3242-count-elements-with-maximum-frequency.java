class Solution {
    public int maxFrequencyElements(int[] nums) {
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

    }
}