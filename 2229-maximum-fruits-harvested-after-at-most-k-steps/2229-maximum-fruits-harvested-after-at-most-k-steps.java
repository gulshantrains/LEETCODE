class Solution {
    public int[] idx;
    public int[] preSum;

    // First index where position > j
    public int rightIdx(int j) {
        int l = 0, r = idx.length - 1;
        int res = idx.length; // default to length (i.e., end)
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (idx[mid] > j) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    // First index where position >= i
    public int leftIdx(int i) {
        int l = 0, r = idx.length - 1;
        int res = idx.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (idx[mid] >= i) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int maxTotalFruits(int[][] A, int Pos, int k) {
        int n = A.length;
        idx = new int[n];
        preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            idx[i] = A[i][0];
            preSum[i + 1] = preSum[i] + A[i][1];
        }

        int res = 0;

        // Go left first i steps, then right (k - 2*i) steps
        for (int i = 0; i <= k; i++) {
            int left = Pos - i;
            int right = Pos + (k - 2 * i);
            if (right < left) continue;
            int l = leftIdx(left);
            int r = rightIdx(right) - 1;
            if (l <= r && r < n) {
                res = Math.max(res, preSum[r + 1] - preSum[l]);
            }
        }

        // Go right first i steps, then left (k - 2*i) steps
        for (int i = 0; i <= k; i++) {
            int right = Pos + i;
            int left = Pos - (k - 2 * i);
            if (left > right) continue;
            int l = leftIdx(left);
            int r = rightIdx(right) - 1;
            if (l <= r && r < n) {
                res = Math.max(res, preSum[r + 1] - preSum[l]);
            }
        }

        return res;
    }
}
