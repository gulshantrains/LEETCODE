class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3) return false;
        int cnt = 0;

        for (var x : arr) {
            if (x % 2 != 0) {
                cnt++;
                if (cnt == 3)
                    break;
            } else
                cnt = 0;
        }
        return cnt == 3;
    }
}