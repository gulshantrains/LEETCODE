class Solution {

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]); // result array
        int n = words.length;

        for (int i = 1; i < n; i++) {
            if (!compare(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    // determine if two words are anagrams
    private boolean compare(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();

        Arrays.sort(w1);
        Arrays.sort(w2);

        return Arrays.equals(w1, w2);
    }
}