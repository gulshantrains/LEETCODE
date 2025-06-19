var partitionArray = function (nums, k) {
    nums.sort((a, b) => a - b);
    let ans = 1;
    let rec = nums[0];
    for (let num of nums) {
        if (num - rec > k) {
            ans++;
            rec = num;
        }
    }
    return ans;
};