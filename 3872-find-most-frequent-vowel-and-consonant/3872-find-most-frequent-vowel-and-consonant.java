class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; // frequency of all letters

        for (char x : s.toCharArray()) {
            freq[x - 'a']++;
        }

        // vowels set
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int maxVowel = 0, maxCons = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (vowels.contains(c)) {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxCons = Math.max(maxCons, freq[i]);
            }
        }

        return maxVowel + maxCons;
    }
}
