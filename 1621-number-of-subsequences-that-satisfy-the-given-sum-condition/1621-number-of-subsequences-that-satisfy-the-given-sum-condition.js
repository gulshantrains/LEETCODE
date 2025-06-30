/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var numSubseq = function (A, target) {
    const mod = 1_000_000_007;
    A.sort((a, b) => a - b);

    let ans = 0;
    let l = 0;
    let r = A.length - 1;
    let n = A.length;

    const pow = new Array(n);
    pow[0] = 1;
    for (let i = 1; i < n; i++) {
        pow[i] = (pow[i - 1] * 2) % mod;
    }

    while (l <= r) {
        if (A[l] + A[r] > target) {
            r--;
        } else {
            ans = (ans + pow[r - l]) % mod;
            l++;
        }
    }
    return ans;


};