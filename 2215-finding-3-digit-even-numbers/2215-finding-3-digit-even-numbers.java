class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> ls = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0)
                continue;

            for (int j = 0; j < digits.length; j++) {
                if (j == i)
                    continue;

                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j)
                        continue;
                    if (digits[k] % 2 != 0)
                        continue;
                    int temp = digits[i] * 100 + digits[j] * 10 + digits[k];

                    ls.add(temp);
                }
            }
        }
        int[] ans = new int[ls.size()];
        int idx = 0;
        for (int x : ls) {
            ans[idx++] = x;
        }
        Arrays.sort(ans);
        return ans;
    }
}