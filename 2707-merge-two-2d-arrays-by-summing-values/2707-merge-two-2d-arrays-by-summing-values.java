class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
       HashMap<Integer,Integer> map=new HashMap<>();

       for(int i=0; i<nums2.length; i++) map.put(nums2[i][0],nums2[i][1]);

       for(int i=0;  i<nums1.length; i++){
        if(map.containsKey(nums1[i][0])){
            int x=map.get(nums1[i][0]);
            map.put(nums1[i][0],nums1[i][1]+x);
        }else
            map.put(nums1[i][0],nums1[i][1]);
       }
       int[][] ans=new int[map.size()][2];
       int i=0;
       for(Map.Entry<Integer,Integer> x: map.entrySet()){
            ans[i][0]=x.getKey();
            ans[i][1]=x.getValue();
            i++;
       }
       Arrays.sort(ans,(a,b)->Integer.compare(a[0],b[0]));
       return ans;
    }
}