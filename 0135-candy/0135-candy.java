class Solution {
    public int candy(int[] r) {
        int n = r.length;
        int[] temp = new int[n];

        Arrays.fill(temp, 1);

        //From Left to Right (By checking all left neighbour)
        for (int i = 1; i < n; i++) {
            if (r[i] > r[i - 1])
                temp[i] = temp[i - 1] + 1;
        }
        //From right to Left (By checking all right neighbour)
        for (int i = n - 2; i >= 0; i--) {
            if (r[i] > r[i + 1])
                temp[i] = Math.max(temp[i + 1] + 1, temp[i]);
        }

        int ans = 0;
        for (var x : temp)
            ans += x;

        return ans;
    }
}