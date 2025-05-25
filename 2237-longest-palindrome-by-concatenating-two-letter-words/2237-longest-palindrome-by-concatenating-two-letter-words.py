from collections import Counter
from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        cnt = Counter(words)
        ans = 0
        flag = False

        for x in list(cnt.keys()):
            rev = x[::-1]

            if rev == x:
                # Each pair of self-palindromic words (e.g., "gg" + "gg") adds 4 to the length.
                ans += (cnt[x] // 2) * 4

                if cnt[x] % 2 == 1:
                    flag = True
            elif x < rev:
                # Ensure the reversed word exists in the counter before accessing its count
                # Counter handles missing keys by returning 0, so direct access is safe here.
                # Each symmetric pair (e.g., "lc" + "cl") adds 4 to the length.
                ans += min(cnt[x], cnt[rev]) * 4

        if flag:
            ans += 2

        return ans
