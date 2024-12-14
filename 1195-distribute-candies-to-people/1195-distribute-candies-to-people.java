class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int giveC = 1;
        int idx = 0;

        while (candies > 0) {
            if(candies > giveC){
                ans[idx % num_people] += giveC;
            }else{
               ans[idx % num_people] += candies; 
            }
            candies -= giveC;
            giveC++;
            idx++;

        }
        return ans;
    }
}