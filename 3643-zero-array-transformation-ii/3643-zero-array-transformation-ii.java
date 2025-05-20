class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (!can(nums, queries, queries.length))
            return -1;

        int l = 0, r = queries.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (can(nums, queries, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private boolean can(int[] nu, int[][] qu, int range) {
        int[] temp = new int[nu.length + 1];

        for (int i = 0; i < range; i++) {
            int l = qu[i][0];
            int r = qu[i][1];
            int val = qu[i][2];

            temp[l] += val;
            temp[r + 1] -= val;
        }

        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }

        for (int i = 0; i < nu.length; i++) {
            if (temp[i] < nu[i])
                return false;
        }

        return true;
    }
}