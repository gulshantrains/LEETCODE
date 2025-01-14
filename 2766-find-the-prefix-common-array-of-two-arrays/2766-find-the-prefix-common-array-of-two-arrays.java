class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[50]; //Freq array lete hai to count number appread till i index
        int[] ans = new int[A.length];
        //TC->O(n)
        for (int i = 0; i < A.length; i++) {
            freq[A[i] - 1]++; // Increase the count of number jo A me aaya hai
            freq[B[i] - 1]++; // Increase the count of number jo B me aaya hai

            int cnt = 0;
            //TC->O(51) or O(n) ===>O(n*51)
            for (int x : freq) {
                if (x == 2) //Agar count 2 ho gaya hai means ki woo common hai 
                    cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}