class Solution {
    public boolean divideArray(int[] nums) {
        int[] ans = new int[501];

        for (int x : nums) ans[x]++;

        for(int x:ans) if(x%2 != 0){return false;}

        return true;
    }
}