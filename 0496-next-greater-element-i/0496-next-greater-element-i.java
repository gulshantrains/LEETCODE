class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums2.length; i++)
            mp.put(nums2[i], i);

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int idx = mp.get(nums1[i]);
            st.push(nums1[i]);

            for (int j = idx; j < nums2.length; j++) {
                if (st.peek() < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                } else {
                    ans[i] = -1;
                }
            }
            st.clear();
        }
        return ans;
    }
}