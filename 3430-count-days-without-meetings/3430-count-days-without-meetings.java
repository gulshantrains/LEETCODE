class Solution {
    public int countDays(int days, int[][] m) {
        Arrays.sort(m, (a, b) -> Integer.compare(a[0], b[0]));

        int busyDay = 0;
        int start = m[0][0], end = m[0][1];

        for (int i = 1; i < m.length; i++) {
            if (m[i][0] <= end) end = Math.max(end, m[i][1]);    
            else {
                busyDay += (end - start + 1);

                // Start a new interval
                start = m[i][0];
                end = m[i][1];
            }
        }
        busyDay += (end - start + 1); // Count last merged interval

        return days - busyDay; // Available days = total days - occupied days
    }
}