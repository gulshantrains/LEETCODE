class Solution {
    public String largestGoodInteger(String nums) {
        int n = nums.length();
        if (n <= 2)
            return "";

        char max = '\0';

        for (int i = 2; i < n; i++) {
            char x = nums.charAt(i), y = nums.charAt(i - 1), z = nums.charAt(i - 2);

            if (x == y && y == z) {
                if (x > max)
                    max = x;
            }

        }
        return max == '\0' ? "" : String.valueOf(max).repeat(3);
    }
}
/*int n = nums.length();
        if (n <= 2)
            return "";

        String ans = "";

        for (int i = 2; i < n; i++) {
            String temp = "";
            char x = nums.charAt(i), y = nums.charAt(i - 1), z = nums.charAt(i - 2);

            if (x == y && y == z) {
                temp = nums.substring(i - 2, i + 1);

                if (ans.isEmpty() || temp.compareTo(ans) > 0)
                    ans = temp;
            }

        }
        return ans;
    }*/