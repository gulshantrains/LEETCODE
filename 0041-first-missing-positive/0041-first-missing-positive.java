class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hst = new HashSet<>();

        for (int x : nums) {
            hst.add(x);
        }
        int min=1;
        while (hst.contains(min))
            min++;

        return min;
    }
}