/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAdjacentDistance = function (n) {
    const s = n.length
    let ans = Math.abs(n[0] - n[s - 1])

    for (let i = 0; i < s - 1; i++) {
        ans = Math.max(ans, Math.abs(n[i] - n[i + 1]))
    }
    return ans
};