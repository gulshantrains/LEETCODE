class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (Is(i))
                return i;
        }
        return -1;

    }

    public boolean Is(int num) {
        int[] freq = new int[10];

        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0 && freq[d] != d)
                return false;
        }

        return true;
    }
}