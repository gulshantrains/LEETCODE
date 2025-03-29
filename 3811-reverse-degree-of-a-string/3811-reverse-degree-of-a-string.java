class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            int val = 'z' - x + 1;
            //System.out.println(val);
            ans += val * (i + 1);
        }
        return ans;
    }
}