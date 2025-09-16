class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int x : nums) ans.add(x);

        int i = 0;
        while (i < ans.size() - 1) {
            int gc = gcd(ans.get(i), ans.get(i + 1));

            if (gc > 1) {
                int lc = lcm(ans.get(i), ans.get(i + 1), gc);
                ans.set(i, lc);      
                ans.remove(i + 1);  

                if (i > 0) i--;     
            } else {
                i++;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b, int gcd) {
        return (int)((long)a * b / gcd); // use long to avoid overflow
    }
}
