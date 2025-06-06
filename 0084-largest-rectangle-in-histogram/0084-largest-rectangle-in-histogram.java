class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] nse = new int[n]; // Next Smaller Element indices
        int[] pse = new int[n]; // Previous Smaller Element indices

        Deque<Integer> dq = new ArrayDeque<>();

        // Compute Previous Smaller Elements (PSE)
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && h[dq.peekLast()] >= h[i]) {
                dq.removeLast();
            }
            pse[i] = dq.isEmpty() ? -1 : dq.peekLast();
            dq.addLast(i);
        }

        dq.clear();

        // Compute Next Smaller Elements (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && h[dq.peekLast()] >= h[i]) {
                dq.removeLast();
            }
            nse[i] = dq.isEmpty() ? n : dq.peekLast();
            dq.addLast(i);
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = h[i];
            int width = nse[i] - pse[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
