class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int ans=0;
        for(int x: nums) pq.offer((long)x); //Put all in min heap

//check for not empty and size >=2 and also top most element is less than k
        while(!pq.isEmpty() && pq.size()>=2 && pq.peek()<k){
            long s1=pq.poll();
            long s2=pq.poll();

            pq.offer(Math.min(s1,s2) * 2 + Math.max(s1,s2));
            ans++;
        }
        return ans;
    }
}