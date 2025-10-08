class Solution {
    public int[] successfulPairs(int[] spells, int[] pot, long success) {
        Arrays.sort(pot);
        int n = spells.length, m = pot.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = BS(pot, success, spells[i]);
            
            ans[i] = (idx == -1) ? 0 : (m - idx);
        }
        return ans;
    }

    // Binary search for first index where pot[mid] * spell >= success
    private int BS(int[] pot, long success, long spell) {
        int l = 0, r = pot.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            long prod = (long) pot[mid] * spell;

            if (prod >= success) {
                ans = mid;
                r = mid - 1;  // look for smaller index
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

/*
class Solution {
    public int[] successfulPairs(int[] s, int[] pot, long range) {
        int n = s.length, m = pot.length;
        int[] ans = new int[n];
        Arrays.sort(pot);

        for (int i = 0; i < n; i++) {
            long idx = BS(pot, range, (long) s[i]);

            if (idx != -1) {
                long total = m - idx;

                ans[i] = (int) total;
            }
        }
        return ans;
    }

    public long BS(int[] arr, long target, long val) {
        int l = 0, r = arr.length - 1;
        long ans = -1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            long tempVal = arr[mid] * val;

            if (tempVal >= target) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        //System.out.println(ans);
        return ans;
    }
}
*/