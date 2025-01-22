/*
--You need to ensure that the elements in the array are distinct
--Remove 3 elements from the beginning of the array. If the array has fewer than 3  elements, remove all remaining elements.
--Return the minimum number of operations needed to make the elements in the array distinct.
*/
class Solution {
    public int minimumOperations(int[] nums) {
        // take a frequency array
        int[] freq = new int[101];
        Arrays.fill(freq,0);

        // now we will start from back (nums.length-1) as from back we will get get to
        // ..know KAUN SE ELEMENT TAK REMOVE KRNA MTLB WHA TAK TO ZARUR HE REMOVE KRNA
        // ..HOGA so we will find kitna count hoga for [n/3]

//count increase kro phle then check kro if we have >1 
//..i+1 as we are 0 indexed & Math.ceil as we haave to round off to INT
        for (int i = nums.length - 1; i >= 0; i--) {
            if (++freq[nums[i]] > 1)
                return (i+3)/3;
        }
        return 0;
    }
}