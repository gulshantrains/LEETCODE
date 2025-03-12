class Solution {
    public int maximumCount(int[] nums) {
       return (int)Math.max(Arrays.stream(nums).filter(p->p>0).count(),Arrays.stream(nums).filter(n->n<0).count());
    }
}
