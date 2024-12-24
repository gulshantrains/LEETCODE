class Solution {
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (var x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> xx : map.entrySet()) {
            if (xx.getValue() == 1)
                return xx.getKey();
        }
        return -1;
    }
}