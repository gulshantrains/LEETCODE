class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mp = new HashMap<>();

        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1); // Put all in map
        }

        int ans = 0;
        boolean hasCenter = false; // Flag to check if we have a single palindromic word for the center

        for (String word : new HashMap<>(mp).keySet()) {
            String temp = word;
            String rev = "" + temp.charAt(1) + temp.charAt(0);

            if (temp.equals(rev)) { // It's a palindromic word like "gg", "aa", etc.
                int cnt = mp.get(temp);

                ans += (cnt / 2) * 4;

                if (cnt % 2 == 1) {
                    hasCenter = true;
                }
            } else if (mp.containsKey(rev)) { // It's a symmetric pair like "lc" and "cl"
                int cntTemp = mp.get(temp);
                int cntRev = mp.get(rev);

                int pairs = Math.min(cntTemp, cntRev); // Number of pairs we can form

                ans += pairs * 4; // Each pair contributes 4 (e.g., "lc" + "cl" -> "lccl")

                mp.put(rev, pairs - mp.get(rev));
                if (mp.get(rev) <= 0)
                    mp.remove(rev);

                mp.put(temp, pairs - mp.get(temp));
                if (mp.get(temp) <= 0)
                    mp.remove(temp);

            }
        }

        if (hasCenter) {
            ans += 2; // Add 2 for the single palindromic word in the center
        }

        return ans;
    }
}