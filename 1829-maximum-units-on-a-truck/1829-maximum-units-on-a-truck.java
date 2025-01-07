class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));

        for (var x : boxTypes) {
            int type = x[0];
            int unit = x[1];

            if (truckSize >= type) {
                ans += (unit * type);
                truckSize -= type;
            } else if (truckSize < type) {
                ans += (truckSize * unit);
                truckSize -= type;
                break;
            }

        }

        return ans;

    }
}