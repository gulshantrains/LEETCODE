class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for (var x : t.toCharArray())
            freq[x - 'a']++;

        for (var x : s.toCharArray())
            freq[x - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;

            return (char) (i + 'a');
        }

        return ' ';
    }
}