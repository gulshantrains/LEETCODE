import java.util.*;

public class Solution {
    private static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        class NumData {
            int digitSum, value, index;

            NumData(int digitSum, int value, int index) {
                this.digitSum = digitSum;
                this.value = value;
                this.index = index;
            }
        }

        NumData[] arr = new NumData[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new NumData(digitSum(nums[i]), nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.value, b.value);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i].index == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
