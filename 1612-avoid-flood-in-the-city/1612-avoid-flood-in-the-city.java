class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> mp = new HashMap<>(); // last day when lake was full
        TreeMap<Integer, Integer> tmp = new TreeMap<>(); // available dry days
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans,2);

        for (int i = 0; i < n; i++) {
            int v = rains[i];

            if (v == 0) {
                tmp.put(i, i); // store dry day index
            } else {
                if (mp.containsKey(v)) {
                    Integer dryDay = tmp.higherKey(mp.get(v)); // next dry day after last fill

                    if (dryDay == null)
                        return new int[0]; // flood -> no dry day available

                    ans[dryDay] = v; // dry this lake on that dry day
                    tmp.remove(dryDay); // dry day used
                }

                mp.put(v, i); // mark lake as full at current day
                ans[i] = -1; // raining day
            }
        }

        return ans;
    }
}
