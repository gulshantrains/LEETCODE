class Solution {
    public int minimumBoxes(int[] appl, int[] cap) {
        int ans = 0;
        int totalSum = Arrays.stream(appl).sum();
        Arrays.sort(cap);

        for (int i = cap.length - 1; i >= 0; i--) {
            if (totalSum > 0) {
                totalSum -= cap[i];
                ans++;
            } else
                break;
        }
        return ans;
    }
}