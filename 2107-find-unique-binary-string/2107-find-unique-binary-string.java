class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for (String x : nums)
            set.add(x);

        int total = 1 << nums.length;

        for (int i = 0; i < total; i++) {
            String no = Integer.toBinaryString(i | (1 << nums.length)).substring(1);
            if (!set.contains(no))
                return no;
        }
        return "";
    }
}