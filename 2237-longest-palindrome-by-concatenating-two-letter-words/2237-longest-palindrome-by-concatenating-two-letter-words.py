class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        mpp = defaultdict(int)
        for w in words:
            mpp[w] += 1

        total_length = 0
        flag = 0

        for word, freq in mpp.items():
            rev = word[::-1]

            if word == rev:
                total_length += (freq // 2) * 4

                if freq % 2 == 1:
                    flag = 1
            else:
                if word < rev and rev in mpp:
                    freq_of_reversed = mpp[rev]
                    number_of_pairs = min(freq, freq_of_reversed)

                    total_length += number_of_pairs * 4

        return total_length + flag * 2
