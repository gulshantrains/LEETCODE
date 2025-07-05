class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[502];

        for (int x : arr)
            freq[x]++;

        for (int i = 501; i >= 0; i--) {
            if (freq[i] == i && freq[i] != 0)
                return i;
        }
        return -1;
    }
}