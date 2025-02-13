class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int ans=0;
        for(int x: nums) pq.offer(x*1L); //Put all in min heap

//check for not empty and size >=2 and also top most element is less than k
        while(!pq.isEmpty() && pq.size()>=2 && pq.peek()<k){
            Long s1=pq.poll();
            Long s2=pq.poll();

            Long val=(Long)Math.min(s1,s2) * 2 + (Long)Math.max(s1,s2);
            pq.offer(val);
            ans++;
        }
        return ans;
    }
}