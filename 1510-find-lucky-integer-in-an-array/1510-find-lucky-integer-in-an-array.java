class Solution {
    static {
        for (int i = 0; i < 100; i++)
            findLucky(new int[0]);
    }

    public static int findLucky(int[] arr) {
        if (arr.length == 0)
            return -1;
        int[] freq = new int[501];

        for (int x : arr)
            freq[x]++;

        for (int i = 500; i > 0; i--) {
            if (i == freq[i])
                return i;
        }
        return -1;
    }
}