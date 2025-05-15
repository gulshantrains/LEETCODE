class Solution {
    public List<String> getLongestSubsequence(String[] wo, int[] gr) {
        List<String> ls = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < gr.length; i++) {
            if (prev == gr[i])
                continue;
            
            ls.add(wo[i]);
            prev = gr[i];
        }
        return ls;
    }
}