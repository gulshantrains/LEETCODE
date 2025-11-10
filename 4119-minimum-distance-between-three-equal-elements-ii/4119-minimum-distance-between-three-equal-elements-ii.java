class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, Deque<Integer>> mp = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            mp.putIfAbsent(val, new ArrayDeque<>());
            Deque<Integer> dq = mp.get(val);

            dq.addLast(i);

            if (dq.size() > 3)
                dq.removeFirst();

            if (dq.size() == 3) {
                int first = dq.peekFirst();
                int last = dq.peekLast();

                minDist = Math.min(minDist, 2 * (last - first));
            }
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }
}