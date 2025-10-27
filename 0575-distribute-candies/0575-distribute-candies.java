class Solution {
    public int distributeCandies(int[] candyType) {
       Set<Integer>mp=new HashSet<>();
       for(int x: candyType) mp.add(x);


       return Math.min(candyType.length>>1,mp.size()); 
    }
}