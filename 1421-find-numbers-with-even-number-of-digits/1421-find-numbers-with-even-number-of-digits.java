class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;

        for (var x : nums)
            if (((int)Math.log10(x)+1) % 2 == 0) cnt++;

        return cnt;
    }
}