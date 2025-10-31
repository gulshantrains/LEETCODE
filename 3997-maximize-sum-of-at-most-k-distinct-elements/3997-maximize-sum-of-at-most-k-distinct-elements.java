class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        // Remove duplicates
        Set<Integer> st = new HashSet<>();
        for (int num : nums) 
            st.add(num);

        // Sort unique numbers in descending order
        List<Integer> ans = new ArrayList<>(st);
        Collections.sort(ans, Collections.reverseOrder());

        // Only take up to k unique elements
        int limit = Math.min(k, ans.size());
        int[] res = new int[limit];

        for (int i = 0; i < limit; i++)
            res[i] = ans.get(i);

        return res;
    }
}
