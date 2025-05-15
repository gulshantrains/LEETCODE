class Solution {
    public List<String> getLongestSubsequence(String[] wo, int[] gr) {
        List<String> ls = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < gr.length; i++) {
            if (prev != gr[i]) {
                prev = gr[i];
                ls.add(wo[i]);
            }
        }
        return ls;
    }
}