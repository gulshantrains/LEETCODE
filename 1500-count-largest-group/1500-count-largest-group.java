class Solution {
    public int countLargestGroup(int n) {
        int[] ds = new int[37];  
        for (int i = 1; i <= n; i++) {
            ds[sum(i)]++;
        }

        // Convert int[] to Integer[] to sort with custom comparator
        Integer[] boxed = new Integer[37];
        for (int i = 0; i < 37; i++) {
            boxed[i] = ds[i];
        }

        Arrays.sort(boxed, (a, b) -> b - a);

        int cnt = 1;
        for (int i = 1; i < 37; i++) {
            if (boxed[i].equals(boxed[i - 1])) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public int sum(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
