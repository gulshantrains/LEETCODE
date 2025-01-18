class Solution {
    private int subArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, cnt = 0, j = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

         //Jaise he size 2 se jda hua window srink kre g left side se
            while (map.size() > k) {
                map.put(nums[j], map.get(nums[j]) - 1);

                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            cnt += (i - j + 1); //No of subArray ending at J ka formula hai
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        //Agr we know till <=k & <=k-1 then Difference dono ka will
        //give exactly K
        return subArray(nums, k) - subArray(nums, k - 1);
    }
}
//Dikkat kya ho rha tha ki hm log [1,2,2] ko ek count kr rahe the
//jbki ussme [1,2,2] & [2,2]--> 2 hai