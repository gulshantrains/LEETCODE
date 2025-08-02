class Solution {
    public long minCost(int[] B1, int[] B2) {
        Map<Integer, Integer> total = new HashMap<>();
        int minVal = (int) 1e9;

        for (int i = 0; i < B1.length; i++) {
            total.merge(B1[i], 1, Integer::sum);
            total.merge(B2[i], -1, Integer::sum);

            minVal = Math.min(minVal, Math.min(B1[i], B2[i]));
        }
        List<Integer> extra = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : total.entrySet()) {
            int k = mp.getKey();
            int v = mp.getValue();

            v = Math.abs(v);

            if (v % 2 != 0) //If v is odd we cant distribute in 2 groups so return -1
                return -1;

            int t = v / 2; //So if we have 4->6 times means distribute 3 and 3 to each so 3's 4 is extra

            for (int i = 0; i < t; i++) {
                extra.add(k);
            }
        }
        extra.sort((a, b) -> a - b); //Sort acc to increasing order
        int half = Math.abs(extra.size() / 2); //Go till N/2 to avoid double swap means 
        //we pair the smallest values from the first half of the list with the largest from the second half to minimize the overall exchange cost.

        long ans = 0;

        for (int i = 0; i < half; i++) {
            ans = ans + Math.min(extra.get(i), 2 * minVal);
        }
        return ans;
    }
}
/*
basket1 = [10, 10, 1, 1]
basket2 = [20, 20, 1, 1]

1st: 
B1=[10,10,20,1]
B2=[20,1,1,1]
Cost=Min(20,1)===>1

2nd:
B1=[10,1,20,1]
B2=[20,1,10,1]
Cost+=Min(1,10)

Total is 2 which is less than direct swap of Min(10,20)->10
*/
