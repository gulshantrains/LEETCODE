class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] w1 = words[i].toCharArray();
            Arrays.sort(w1);

            for (int j = i + 1; j < n; j++) {
                if (words[i] == "1")
                    continue;

                char[] w2 = words[j].toCharArray();
                Arrays.sort(w2);

                if (!Arrays.equals(w1, w2)) {
                    break;
                } else
                    words[j] = "1";

            }
            if (words[i] != "1")
                ans.add(words[i]);
        }
        return ans;
    }
}