class Solution {
    public int distributeCandies(int[] candyType) {
       Map<Integer,Integer>mp=new HashMap<>();
       for(int x: candyType) mp.merge(x,1,Integer::sum);

       int can=candyType.length>>1;

       return Math.min(can,mp.size()); 
    }
}