//Convert 0 to -1 && 1 to 1 so that whenever equal then sum if zero or have same sum
class Solution {
    public int findMaxLength(int[] nums) {
        int[] ne = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int cnt = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                ne[i] = -1;
            else
                ne[i] = 1;
        }
        for (int i = 0; i < ne.length; i++) {
            cnt += ne[i];

            if (!map.containsKey(cnt)) {
                map.put(cnt, i);
            } else {
                int x = map.get(cnt);
                ans = Math.max(ans,i - x);
            }
        }
        return ans;

    }
}

// Arrays.stream(zero).forEach(System.out::print);
// System.out.println("");
// Arrays.stream(one).forEach(System.out::print);