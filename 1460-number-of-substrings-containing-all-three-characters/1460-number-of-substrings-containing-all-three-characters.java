class Solution {
    public int numberOfSubstrings(String s) {
        int[] mp=new int[3];
        int ans = 0, n = s.length(), i = 0, j=0;

        while(j<n){
            char x=s.charAt(j);
            mp[x-'a']++;

            while(mp[0]>0 && mp[1]>0 && mp[2]>0){
                ans +=(n-j);

                char xx=s.charAt(i);
                mp[xx-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}