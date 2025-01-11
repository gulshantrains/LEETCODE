class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] ar = new int[101];

        for (int i = 0; i < nums.size(); i++) {
            int l = nums.get(i).get(0);
            int r = nums.get(i).get(1);

            for (int j = l; j <= r; j++) {
                if (ar[j] == 0)
                    ar[j] = 1;
            }
        }

        int cnt = 0;
        for (int x : ar) {
            if (x > 0)
                cnt++;
        }
        return cnt;

    }
}