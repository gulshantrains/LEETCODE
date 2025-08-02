class Solution {
    public long minCost(int[] B1, int[] B2) {
        Map<Integer, Integer> total = new HashMap<>();
        int minVal = (int) 1e9;

        for (int i = 0; i < B1.length; i++) {
            total.merge(B1[i], 1, Integer::sum);
            total.merge(B2[i], -1, Integer::sum);

            minVal = Math.min(minVal, Math.min(B1[i], B2[i]));
        }
        List<Integer> extra = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : total.entrySet()) {
            int k = mp.getKey();
            int v = mp.getValue();

            v = Math.abs(v);

            if (v % 2 != 0)
                return -1;
            int t = v / 2; //So if we have 4->6 times means distribute 3 and 3 to each so 3's 4 is extra

            for (int i = 0; i < t; i++) {
                extra.add(k);
            }
        }
        extra.sort((a, b) -> a - b); //Sort acc to increasing order
        int half = Math.abs(extra.size() / 2);

        long ans = 0;

        for (int i = 0; i < half; i++) {
            ans = ans + Math.min(extra.get(i), 2 * minVal);
        }
        return ans;
    }
}