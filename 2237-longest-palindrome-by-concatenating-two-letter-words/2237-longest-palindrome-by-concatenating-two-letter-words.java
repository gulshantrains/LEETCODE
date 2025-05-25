class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mpp = new HashMap<>();
        for (var w : words) {
            mpp.put(w, mpp.getOrDefault(w, 0) + 1);
        }

        int totalLength = 0;
        int flag = 0;

        for (var x : mpp.entrySet()) {
            String word = x.getKey();
            int freq = x.getValue();

            String rev = "" + word.charAt(1) + word.charAt(0);

            if (word.equals(rev)) {
                totalLength += (freq / 2) * 4;

                if (freq % 2 == 1) {
                    flag = 1;
                }
            } else {
                if (word.compareTo(rev) < 0 && mpp.containsKey(rev)) {
                    int freqOfReversed = mpp.get(rev);
                    int numberOfPairs = Math.min(freq, freqOfReversed);

                    totalLength += numberOfPairs * 4;
                }
            }
        }

        return totalLength + flag * 2;
    }
}