class Solution {
    public int maximumSum(int[] nums) {
        //To store digitsum->MAX(number)
        HashMap<Integer, Integer> maxdig = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = sum(num);

            if (maxdig.containsKey(digitSum)) {//Already koi hai phle se
                maxSum = Math.max(maxSum, num + maxdig.get(digitSum));

                if (maxdig.get(digitSum) < num)//current num wla is Bigger than old
                    maxdig.put(digitSum, num);
            } else
                maxdig.put(digitSum, num);
        }

        return maxSum;
    }

    private int sum(int num) {
        int s = 0;
        while (num != 0) {
            s += num % 10;
            num /= 10;
        }
        return s;
    }
}
