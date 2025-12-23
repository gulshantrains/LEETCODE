class Solution {
    public long minCost(String s, int[] cost) {
        int n = cost.length;
        long ans = Long.MAX_VALUE, totalVal = 0;
        long[] freq = new long[26];

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            totalVal += cost[i];

            freq[cur - 'a'] += cost[i];

        }
        for (int i = 0; i < n; i++) {
            long cur = totalVal - freq[s.charAt(i) - 'a']; //Deletion cost of all other

            ans = Math.min(ans, cur);
        }

        return ans;
    }
}
/*
->Choose any one charcter(a-z) to keep
->Delete all other
->Minimize cost of deletion so so so

Cost of keeping this character=Total cost - this C cost
Total cost - this C cost==Deletion cost 
so Minimize it
*/