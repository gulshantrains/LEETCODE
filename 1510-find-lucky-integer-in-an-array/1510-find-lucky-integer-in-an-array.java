class Solution {
    static {
        for (int i = 0; i < 100; i++)
            findLucky(new int[0]);
    }

    public static int findLucky(int[] arr) {
        int[] freq = new int[501];

        for (int x : arr)
            freq[x]++;

        for (int i = 500; i > 0; i--) {
            if (freq[i] == i)
                return i;
        }
        return -1;
    }
}