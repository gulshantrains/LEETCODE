class Solution {
    public int totalNumbers(int[] dig) {
        HashSet<Integer> set = new HashSet<>();
        int n = dig.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) {
                        if (dig[i] != 0 && dig[k] % 2 == 0) {
                            int number = dig[i] * 100 + dig[j] * 10 + dig[k];

                            set.add(number);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}