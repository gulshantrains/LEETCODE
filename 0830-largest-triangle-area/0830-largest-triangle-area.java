class Solution {
    public double largestTriangleArea(int[][] p) {
        double ans = 0;
        int n = p.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, find(p[i], p[j], p[k]));
                }
            }
        }
        return ans;
    }

    public double find(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(
            A[0]*B[1] + B[0]*C[1] + C[0]*A[1] - B[0]*A[1] - C[0]*B[1] - A[0]*C[1]
        );
    }
}
