/**
 * @param {number[]} A
 * @param {number} target
 * @return {number}
 */
var numSubseq = function (A, target) {
    const MOD = 10 ** 9 + 7
    const subsets = []
    subsets[0] = 1
    for (let i = 1; i < A.length; i++) {
        subsets[i] = (subsets[i - 1] * 2) % MOD
    }
    A.sort((a, b) => a - b)
    let count = 0
    let left = 0
    let right = A.length - 1
    while (left <= right) {
        if (A[left] + A[right] > target) {
            right--
        } else {
            count = (count + subsets[right - left]) % MOD
            left++
        }
    }
    return count

};