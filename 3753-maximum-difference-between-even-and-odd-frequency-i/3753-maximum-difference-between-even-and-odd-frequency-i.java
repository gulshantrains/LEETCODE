class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        for (var x : s.toCharArray()) {
            freq[x - 'a']++;
        }

        int od = 0, ev = 100000;

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && freq[i] % 2 == 0) { //Even hai
                if (ev > freq[i])
                    ev = freq[i];
            } else { //Odd hai
                if (freq[i] > od) {
                    od = freq[i];
                }
            }
        }
        return od - ev;

    }
}