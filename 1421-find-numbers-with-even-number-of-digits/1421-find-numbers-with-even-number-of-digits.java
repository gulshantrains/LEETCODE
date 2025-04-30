class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;

        for (var x : nums){
            int dig=String.valueOf(x).length();

            if(dig%2==0) cnt++;
        }
        return cnt;
    }
}