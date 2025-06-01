class Solution {
    // Helper function to calculate  to distribute 'k' candies to 3 children
    // This is C(k+2, 2) = (k+2)*(k+1)/2 [Rod method] for 3 people 2 rod will needed
    public static long helper(long candies) {
        if (candies < 0) {
            return 0;
        }
        return (candies + 2) * (candies + 1) / 2;
    }

    public long distributeCandies(long n, long limit) {

        // Case 1. Total  to distribute 'n' candies without any limit
        long total = helper(n);

        // Case 2.  where AT LEAST ONE child gets more than 'limit' candies
        //    Suppose child A gets 'limit + 1' candies. Remaining: n - (limit + 1)
        //    There are 3 such children (A, B, or C).

        long OneExceeds = 3 * helper(n - (limit + 1));

        // Case 3.  where AT LEAST TWO children get more than 'limit' candies
        //    Suppose children A and B each get 'limit + 1' candies.
        //    Total given out: 2 * (limit + 1). Remaining: n - 2 * (limit + 1)
        //    There are C(3,2) = 3 such pairs of children ((A,B), (A,C), (B,C)).

        long TwoExceed = 3 * helper(n - 2 * (limit + 1));

        // Case 4.  where AT LEAST THREE children get more than 'limit' candies
        //    Suppose children A, B, and C each get 'limit + 1' candies.
        //    Total given out: 3 * (limit + 1). Remaining: n - 3 * (limit + 1)
        //    There is C(3,3) = 1 such triplet of children.

        long ThreeExceed = 1 * helper(n - 3 * (limit + 1));

        // Apply the Principle of Inclusion-Exclusion:
        // Result = Total - (1 child violates) + (2 children violate) - (3 children violate)
        long result = total - OneExceeds + TwoExceed - ThreeExceed;

        return result;
    }
}