class Solution {
    public boolean isValid(int[] freq) {
        int k = 0;

        for (int x : freq) {
            if (x == 0)
                continue;

            if (k == 0)
                k = x;
            else if (x != k)
                return false;
        }

        return true;
    }

    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (var x : word.toCharArray()) {
            freq[x - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;

            freq[i]--;

            if (isValid(freq))
                return true;

            freq[i]++;
        }
        return false;
    }
}