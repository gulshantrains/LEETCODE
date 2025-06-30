class Solution {
    public int findLHS(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = A.length;
        int ans = 0;

        for (var x : A) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        for (var key : mp.keySet()) {
            int need = key + 1;
            int currLen = 0;

            if (mp.containsKey(need)) {
                currLen = mp.get(need) + mp.get(key);

            }
            ans = Math.max(ans, currLen);
        }
        return ans;
    }
}