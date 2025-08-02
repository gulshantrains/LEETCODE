class Solution {
    public long minCost(int[] A, int[] B) {
        TreeMap<Integer, Integer> total = new TreeMap<>(); // FIXED

        for (int i = 0; i < A.length; i++) {
            total.merge(A[i], 1, Integer::sum);
            total.merge(B[i], -1, Integer::sum);
        }

        long ans = 0, minVal = total.firstKey();  // ✅ Works now
        List<Integer> extra = new ArrayList<>();

        for (int e : total.keySet()) {
            if (total.get(e) % 2 != 0) return -1;  // odd difference = impossible

            for (int i = 0; i < Math.abs(total.get(e)) / 2; i++) {
                extra.add(e);
            }
        }

        // Collections.sort(extra);  // Ensure sorted to get min cost

        for (int i = 0; i < extra.size() / 2; i++) {
            ans += Math.min(extra.get(i), 2 * minVal);
        }

        return ans;
    }
}
