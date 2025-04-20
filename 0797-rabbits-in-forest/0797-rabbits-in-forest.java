class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1000];
        for (int a : answers) {
            freq[a]++;
        }

        int total = 0;
        for (int x = 0; x < 1000; x++) {
            int count = freq[x];
            if (count == 0) continue;

            int groupSize = x + 1; 
            int groups = (count + groupSize - 1) / groupSize;

            total += groups * groupSize;
        }

        return total;
    }
}
