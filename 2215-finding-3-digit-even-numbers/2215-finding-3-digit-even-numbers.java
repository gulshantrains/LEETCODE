import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] d) {
        Set<Integer> set = new TreeSet<>();  // TreeSet to keep results sorted and unique

        int n = d.length;
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) continue; // Hundreds place cannot be 0

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    if (d[k] % 2 != 0) continue; // Last digit must be even

                    int num = d[i] * 100 + d[j] * 10 + d[k];
                    set.add(num);
                }
            }
        }

        // Convert Set<Integer> to int[]
        int[] result = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            result[idx++] = num;
        }

        return result;
    }
}
