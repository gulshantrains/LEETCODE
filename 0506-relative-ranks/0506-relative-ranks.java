class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] cp = score.clone();
        cp = cp = Arrays.stream(cp) // Convert to stream
                .boxed() // Convert int to Integer
                .sorted((a, b) -> b - a) // Sort in descending order
                .mapToInt(Integer::intValue) // Convert back to int[]
                .toArray();
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < cp.length; i++) {
            int x = i + 1;
            if (i == 0)
                map.put(cp[i], "Gold Medal");
            else if (i == 1)
                map.put(cp[i], "Silver Medal");
            else if (i == 2)
                map.put(cp[i], "Bronze Medal");
            else
                map.put(cp[i], String.valueOf(x));
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}