class Solution {
    public boolean check(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        int d=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) d++;

            if(d>1) return false;
        }
        return d==1;
    }

    public List<String> getWordsInLongestSubsequence(String[] w, int[] g) {
        List<String> ans = new ArrayList<>();
        int n = g.length;
        int maxLidx = 0;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((check(w[i], w[j])) && (dp[j] + 1 > dp[i]) && (g[i] != g[j])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
                if (dp[i] > dp[maxLidx]) {
                    maxLidx = i;
                }
            }
        }
        for (int i = maxLidx; i >= 0; i = prev[i]) {
            ans.add(w[i]);
        }
        Collections.reverse(ans);

        return ans;

    }
}