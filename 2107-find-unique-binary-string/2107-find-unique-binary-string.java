class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        //Add string to Set TC->O(n)
        for (String x : nums)
            set.add(x);
        // 2^n (bitwise shift left and we will go till 2^n-1;
        //1<<3-----1000
        int total = 1 << nums.length;

        for (int i = 0; i < total; i++) {
            //convert into binarystring and make it of length n
            String no = Integer.toBinaryString(i | (1 << nums.length)).substring(1);
            if (!set.contains(no))
                return no;
        }
        return "";//Will never reach here
    }
}