/**
 * @param {string} s
 * @param {number} k
 * @param {character} fill
 * @return {string[]}
 */
var divideString = function (s, k, fill) {
    const ans = []
    const n = s.length

    let curr = 0

    while (curr < n) {
        const end = Math.min(curr + k, n)
        ans.push(s.slice(curr, end))
        curr += k
    }
    const lastString = ans[ans.length - 1]
    if (lastString.length < k) {
        ans[ans.length - 1] = lastString + fill.repeat(k - lastString.length)
    }
    return ans
};